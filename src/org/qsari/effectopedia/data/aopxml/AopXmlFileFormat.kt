package org.qsari.effectopedia.data.aopxml

import org.qsari.effectopedia.base.io.BaseIO
import org.qsari.effectopedia.data.DataSource
import org.qsari.effectopedia.data.RevisionBasedDS
import org.qsari.effectopedia.data.formats.DataSourceFormat
import org.qsari.effectopedia.data.formats.FormatFlavour
import org.qsari.effectopedia.notification.NotificationManager

import java.io.File
import java.util.ArrayList
import org.qsari.effectopedia.data.formats.DataSourceFormat.SupportedFeatures

object AopXmlFileFormat : DataSourceFormat {
    var DefaultFlavour = FormatFlavour("aopx", "AOP-XML", FormatFlavour.UNDEFINED)
    private val _flavours = listOf(DefaultFlavour)

    override fun createDataSource(): RevisionBasedDS {
        return this.createDataSource(DefaultFlavour)
    }

    override fun createDataSource(withFlavour: FormatFlavour): RevisionBasedDS {
        return AopXmlDataSource()
    }

    override fun createNotificationManager(): NotificationManager {
        return NonFunctionalNotificationManager()
    }

    override fun getFormatName(): String {
        return "AOP-XML"
    }

    override fun getImplementationDescription(): String {
        return "AOP-XML"
    }

    override fun getFlavours(): ArrayList<FormatFlavour> {
        // Defensive copy because return value is mutable.
        return ArrayList(this._flavours)
    }

    override fun isCompatible(sourceName: String, withFlavour: FormatFlavour): Boolean {
        return File(sourceName).exists()
    }

    override fun allows() : SupportedFeatures {
		return SupportedFeatures.IMPORT_EXPORT;
	}

	    internal class NonFunctionalNotificationManager : NotificationManager {
        override fun buildAndSubmitNotifications(data: DataSource, io: BaseIO) {}
        override fun buildAndSubmitNotifications(data: DataSource, io: BaseIO, sinceRevision: Int) {}
    }
}
