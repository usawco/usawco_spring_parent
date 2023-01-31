package FixBuilding.com.sag;

public class Instruction {
	
	private static String PKG_FIRST_INSTRUCTION = "install.phase4="+"\\"+"extract(include:IntegrationServer/replicate/inbound/_DISPLAY_FIX_NAME_JAR_);"+"\\";
	private static String JAR_FIRST_INSTRUCTION = "install.phase4="+"\\"+"extract(include:IntegrationServer/updates/_DISPLAY_FIX_NAME_JAR_);"+"\\";
	private static String PKG_INSTRUCTION = "extract(include:IntegrationServer/replicate/inbound/_DISPLAY_FIX_NAME_JAR_);"+"\\";;
	private static String PKG_INSTALL_INSTRUCTION = "installPackageMultiInstance(packageFile:_DISPLAY_FIX_NAME_JAR_,packageName:_TARGET_PACKAGE_);"+"\\";
	
	public static String getPackageFirstInstruction(PackageFix packageFix) {
		return PKG_FIRST_INSTRUCTION.replaceAll("_DISPLAY_FIX_NAME_JAR_", packageFix.getPkgZipName());
	}
	
	public static String getPackageInstruction(PackageFix packageFix) {
		return PKG_INSTRUCTION.replaceAll("_DISPLAY_FIX_NAME_JAR_", packageFix.getPkgZipName());
	}

	public static String getJarFirstInstruction(SUMFix sumFix) {
		return JAR_FIRST_INSTRUCTION.replaceAll("_DISPLAY_FIX_NAME_JAR_", sumFix.getFixJarName());
	}
	
	public static String getPackageInstallInstruction(PackageFix packageFix) {
		return PKG_INSTALL_INSTRUCTION.replaceAll("_TARGET_PACKAGE_", packageFix.getPackgeName())
		.replaceAll("_DISPLAY_FIX_NAME_JAR_", packageFix.getPkgZipName());
	}
}
