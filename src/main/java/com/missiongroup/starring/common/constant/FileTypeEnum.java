package com.missiongroup.starring.common.constant;

import com.alibaba.druid.util.StringUtils;
import com.missiongroup.starring.core.support.StrKit;

/**
 * 
 * 文件类型的枚举
 *
 * @author mission
 * @date 2017年3月5日 上午10:15:02
 */
public enum FileTypeEnum {

	XML(0, "XML", "fileicon-sys-s-code", "fileicon-sys-l-code"), //
	ZIP(0, "ZIP", "fileicon-small-zip", "fileicon-large-zip"), //
	RAR(0, "RAR", "fileicon-small-zip", "fileicon-large-zip"), //
	MMAP(0, "MMAP", "fileicon-small-mmap", "fileicon-large-mmap"), //
	MM(0, "mm", "fileicon-small-mm", "fileicon-large-mm"), //
	XMIND(0, "XMIND", "fileicon-small-xmind", "fileicon-large-xmind"), //
	BT(0, "BT", "fileicon-small-bt", "fileicon-large-bt"), //
	APK(0, "APK", "fileicon-sys-s-apk", "fileicon-sys-l-apk"), //
	AI(0, "AI", "fileicon-sys-s-ai", "fileicon-sys-l-ai"), //
	API(0, "API", "fileicon-sys-s-ipa", "fileicon-sys-l-ipa"), //
	EXE(0, "EXE", "fileicon-sys-s-exe", "fileicon-sys-l-exe"), //
	HTML(0, "HTML", "fileicon-sys-s-web", "fileicon-sys-l-web"), //
	HTM(0, "HTM", "fileicon-sys-s-web", "fileicon-sys-l-web"), //
	DWS(0, "DWS", "fileicon-small-dws", "fileicon-large-dws"), //
	VSD(0, "VSD", "fileicon-small-vsd", "fileicon-large-vsd"), //
	PSD(0, "PSD", "fileicon-sys-s-psd", "fileicon-sys-large-psd"), //
	SWF(0, "SWF", "fileicon-sys-s-swf", "fileicon-sys-l-swf"), //
	EPS(0, "EPS", "fileicon-sys-s-eps", "fileicon-sys-l-eps"), //
	
	DOC(1, "DOC", "fileicon-small-doc", "fileicon-large-doc"), //
	DOCX(1, "DOCX", "fileicon-small-doc", "fileicon-large-doc"), //
	PPT(1, "PPT", "fileicon-small-ppt", "fileicon-large-ppt"), //
	PDF(1, "PDF", "fileicon-small-pdf", "fileicon-large-pdf"), //
	TXT(1, "TXT", "fileicon-small-txt", "fileicon-large-txt"), //
	XLS(1, "XLS", "fileicon-small-xls", "fileicon-large-xls"), //
	WPS(1, "WPS", "fileicon-small-doc", "fileicon-large-doc"), //
	RTF(1, "RTF", "fileicon-small-doc", "fileicon-large-doc"), //
	HLP(1, "HLP", "fileicon-small-doc", "fileicon-large-doc"), //
	XLSX(1, "XLSX", "fileicon-small-xls", "fileicon-large-xls"), //
	
	PNG(2, "PNG", "fileicon-small-pic", "fileicon-middle-pic"), //
	JPG(2, "JPG", "fileicon-small-pic", "fileicon-middle-pic"), //
	JPEG(2, "JPEG", "fileicon-small-pic", "fileicon-middle-pic"), //
	GIF(2, "GIF", "fileicon-small-pic", "fileicon-middle-pic"), //
	PIC(2, "PIC", "fileicon-small-pic", "fileicon-middle-pic"), //
	BMP(2, "BMP", "fileicon-small-pic", "fileicon-middle-pic"), //
	
	MP3(3, "MP3", "fileicon-small-mp3", "fileicon-large-mp3"), //
	WAV(3, "WAV", "fileicon-small-mp3", "fileicon-large-mp3"), //
	AIF(3, "AIF", "fileicon-small-mp3", "fileicon-large-mp3"), //
	AU(3, "AU", "fileicon-small-mp3", "fileicon-large-mp3"), //
	RAM(3, "RAM", "fileicon-small-mp3", "fileicon-large-mp3"), //
	WMA(3, "WMA", "fileicon-small-mp3", "fileicon-large-mp3"), //
	MMF(3, "MMF", "fileicon-small-mp3", "fileicon-large-mp3"), //
	AMR(3, "AMR", "fileicon-small-mp3", "fileicon-large-mp3"), //
	AAC(3, "AAC", "fileicon-small-mp3", "fileicon-large-mp3"), //
	FLAC(3, "FLAC", "fileicon-small-mp3", "fileicon-large-mp3"), //
	OGG(3, "OGG", "fileicon-small-mp3", "fileicon-large-mp3"), //
	
	AVI(4, "AVI", "fileicon-small-video", "fileicon-large-video"), //
	GP3(4, "3GP", "fileicon-small-video", "fileicon-large-video"), //
	MPEG(4, "MPEG", "fileicon-small-video", "fileicon-large-video"), //
	MPG(4, "MPG", "fileicon-small-video", "fileicon-large-video"), //
	DAT(4, "DAT", "fileicon-small-video", "fileicon-large-video"), //
	MKV(4, "MKV", "fileicon-small-video", "fileicon-large-video"), //
	RMVB(4, "RMVB", "fileicon-small-video", "fileicon-large-video"), //
	WMV(4, "WMV", "fileicon-small-video", "fileicon-large-video"), //
	ASF(4, "ASF", "fileicon-small-video", "fileicon-large-video"), //
	MP4(4, "MP4", "fileicon-small-video", "fileicon-large-video");

	private Integer type;

	private String extension;

	private String smallIcon;
	
	private String largeIcon;

	FileTypeEnum(int type, String extension, String smallIcon, String largeIcon) {
		this.type = type;
		this.extension = extension;
		this.smallIcon = smallIcon;
		this.largeIcon = largeIcon;
	}

	public static Integer typeOf(String extension) {
		if (StringUtils.isEmpty(extension)) {
			return 0;
		} else {
			for (FileTypeEnum s : FileTypeEnum.values()) {
				if (s.getExtension().equals(extension.toUpperCase())) {
					return s.getType();
				}
			}
			return 0;
		}
	}

	public static String extensionOf(Integer type) {
		String extension = "";
		if (type == null) {
			return "";
		} else {
			for (FileTypeEnum s : FileTypeEnum.values()) {
				if (s.getType() == type) {
					extension = extension + s.getExtension() + ",";
				}
			}
			return StrKit.removeSuffix(extension, ",");
		}
	}

	public static String smallIconOf(String extension) {
		String iconClass = "default-small";
		if (StringUtils.isEmpty(extension)) {
			return "default-small";
		} else {
			for (FileTypeEnum s : FileTypeEnum.values()) {
				if (s.getExtension().equals(extension.toUpperCase())) {
					iconClass = s.getSmallIcon();
				}
			}
			return iconClass;
		}
	}
	
	public static String largeIconOf(String extension) {
		String iconClass = "default-large";
		if (StringUtils.isEmpty(extension)) {
			return "default-large";
		} else {
			for (FileTypeEnum s : FileTypeEnum.values()) {
				if (s.getExtension().equals(extension.toUpperCase())) {
					iconClass = s.getLargeIcon();
				}
			}
			return iconClass;
		}
	}

	public String getSmallIcon() {
		return smallIcon;
	}

	public String getLargeIcon() {
		return largeIcon;
	}

	public void setSmallIcon(String smallIcon) {
		this.smallIcon = smallIcon;
	}

	public void setLargeIcon(String largeIcon) {
		this.largeIcon = largeIcon;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
}
