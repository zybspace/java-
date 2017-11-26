创建文件夹
  File catalog = new File("d:/myFile/aaa");
  boolean success = catalong.mkdir(); //当父级目录存在时，创建文件夹，否则创建失败
  boolean success = catalong.mkdirs();  //创建文件夹，当父级目录不存在时，先创建父级目录
  
创建新文件
  File catalog = new File("d:/myFile");
  boolean exists = file.createNewFile();  //不存在就返回true；存在返回false，不会创建父级目录
  

InputStream is;
OutputStream od;
复制文件：
   File file = new File("d:/myFile/aaa.txt");    //声明待复制文件
   FileInputStream fileInputStream = new FileInputStream(file);  //根据待复制文件创建文件输入流
   File copyFile  = new File("d:/myFile/aaa_copy.txt");   //声明复制目标文件
   FileOutputStream fileOutputStream = new FileOutputStream(copyFile);    //声明复制目标文件输出流
   
  
