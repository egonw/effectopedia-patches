package org.openide.awt;

/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 * An icon that paints a small arrow to the right of the provided icon.
 * 
 * @author S. Aubrecht
 * @since 6.11
 */
class IconWithArrow extends ImageIcon
	{

		/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
		private static final String	ARROW_IMAGE_NAME	= "res/arrow.png";
		public  static final ImageIcon ARROW_ICON = new ImageIcon(IconWithArrow.class.getResource(ARROW_IMAGE_NAME));
		
		private Icon																orig;
		private Icon																arrow												= ARROW_ICON;
		private boolean													paintRollOver;
		
		private static final int				GAP														= 6;
		
		/** Creates a new instance of IconWithArrow */
		public IconWithArrow(Icon orig, boolean paintRollOver)
			{
				this.orig = orig;
				this.paintRollOver = paintRollOver;
			}
		
		public void paintIcon(Component c, Graphics g, int x, int y)
			{
				int height = getIconHeight();
				orig.paintIcon(c, g, x, y + (height - orig.getIconHeight()) / 2);
				
				arrow.paintIcon(c, g, x + GAP + orig.getIconWidth(), y + (height - arrow.getIconHeight()) / 2);
				
				if (paintRollOver)
					{
						Color brighter = UIManager.getColor("controlHighlight"); // NOI18N
						Color darker = UIManager.getColor("controlShadow"); // NOI18N
						if (null == brighter || null == darker)
							{
								brighter = c.getBackground().brighter();
								darker = c.getBackground().darker();
							}
						if (null != brighter && null != darker)
							{
								g.setColor(brighter);
								g.drawLine(x + orig.getIconWidth() + 1, y, x + orig.getIconWidth() + 1, y + getIconHeight());
								g.setColor(darker);
								g.drawLine(x + orig.getIconWidth() + 2, y, x + orig.getIconWidth() + 2, y + getIconHeight());
							}
					}
			}
		
		public int getIconWidth()
			{
				return orig.getIconWidth() + GAP + arrow.getIconWidth();
			}
		
		public int getIconHeight()
			{
				return Math.max(orig.getIconHeight(), arrow.getIconHeight());
			}
		
		public static int getArrowAreaWidth()
			{
				return GAP / 2 + 5;
			}

		public Image getImage()
			{
				BufferedImage image = new BufferedImage(getIconWidth(), getIconHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.getGraphics();
    paintIcon(new JLabel(), g, 0, 0);
    g.dispose();
    return image;
			}
		
	}
