// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0740 {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir, "");
  }

  static void printClasses(File dir, String packageName) {
    if (packageName.length() > 0) {
      packageName += ".";
    }
    File[] files = dir.listFiles(
        file -> file.isDirectory() || (file.isFile() && file.getName().endsWith(".class")));
    for (File file : files) {
      if (file.isDirectory()) {
        printClasses(file, packageName + file.getName());
      } else {
        System.out.println(packageName + file.getName().replace(".class", ""));
      }
    }
  }
}


