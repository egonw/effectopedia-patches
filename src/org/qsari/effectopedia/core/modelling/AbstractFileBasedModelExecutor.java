package org.qsari.effectopedia.core.modelling;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntry.Builder;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.qsari.effectopedia.data.objects.Resource;

public abstract class AbstractFileBasedModelExecutor extends AbstractModelExecutor
	{
		protected Path	workPath;
		
		public boolean initResources()
			{
				if (model != null)
					workPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), "EGM" + model.getID());
				else
					workPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"));
				
				if (!generateResources())
					{
						console.println("Generation of matlab files and resources failed!");
						return false;
					}
				return true;
			}
		
		protected boolean generateResources()
			{
				if (model == null)
					return false;
				// if (fileAttributes == null)
				// generateFileAttributes();
				if (!Files.exists(workPath))
					try
						{
							// Files.createDirectory(workPath, fileAttributes);
							Files.createDirectory(workPath);
						}
					catch (IOException e)
						{
							e.printStackTrace(console);
							return false;
						}
				for (Resource resource : model.getResources().getCachedObjects())
					{
						Path fileName = workPath.resolve(resource.getFileName());
						try
							{
								java.nio.file.Files.write(fileName, resource.getContent().getBytes("utf-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
							}
						catch (IOException e)
							{
								e.printStackTrace(console);
								return false;
							}
					}
				return true;
			}
		
		protected void generateFileAttributes()
			{
				if (FileSystems.getDefault().supportedFileAttributeViews().contains(PosixFileAttributeView.class))
					{
						Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("drwxrwxrwx");
						fileAttributes = PosixFilePermissions.asFileAttribute(permissions);
					}
				else if (FileSystems.getDefault().supportedFileAttributeViews().contains(AclFileAttributeView.class))
					fileAttributes = new FileAttribute<List<AclEntry>>()
						{
							
							@Override
							public List<AclEntry> value()
								{
									// lookup user principal
									FileSystem fileSystem = FileSystems.getDefault();
									UserPrincipalLookupService userPrincipalLookupService = fileSystem.getUserPrincipalLookupService();
									UserPrincipal userPrincipal = null;
									try
										{
											userPrincipal = userPrincipalLookupService.lookupPrincipalByName("JStas");
										}
									catch (IOException e)
										{
											throw new RuntimeException(e);
										}
									
									// select ACL flags
									Set<AclEntryFlag> flags = EnumSet.of(AclEntryFlag.FILE_INHERIT, AclEntryFlag.DIRECTORY_INHERIT);
									
									// select ACL permission
									Set<AclEntryPermission> permissions = EnumSet.of(AclEntryPermission.READ_DATA, AclEntryPermission.WRITE_DATA, AclEntryPermission.EXECUTE);
									
									// build ACL entry
									Builder builder = AclEntry.newBuilder();
									builder.setFlags(flags);
									builder.setPermissions(permissions);
									builder.setPrincipal(userPrincipal);
									builder.setType(AclEntryType.DENY);
									
									AclEntry entry = builder.build();
									List<AclEntry> aclEntryList = new ArrayList<>();
									aclEntryList.add(entry);
									
									return aclEntryList;
								}
							
							@Override
							public String name()
								{
									return "acl:acl";
								}
						};
				
			}
		
		protected int														lastObjPropDefEnd	= 0;
		protected FileAttribute<?>	fileAttributes				= null;
		
	}
