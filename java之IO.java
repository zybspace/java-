创建文件夹
  File catalog = new File("d:/myFile/aaa");
  boolean success = catalong.mkdir(); //当父级目录存在时，创建文件夹，否则创建失败
  boolean success = catalong.mkdirs();  //创建文件夹，当父级目录不存在时，先创建父级目录
  
创建新文件
  File catalog = new File("d:/myFile");
  boolean exists = file.createNewFile();  //不存在就返回true；存在返回false，不会创建父级目录
  
字节流输入、输出
InputStream 、 OutputStream
字符流输入、输出
Reader、Writer
 
复制文件：
   字节流方法
       File file = new File("d:/myFile/aaa.txt");    //声明待复制文件
       FileInputStream fileInputStream = new FileInputStream(file);  //根据待复制文件创建文件输入流
       File copyFile  = new File("d:/myFile/aaa_copy.txt");   //声明复制目标文件
       FileOutputStream fileOutputStream = new FileOutputStream(copyFile);    //声明复制目标文件输出流
       //文件复制过程
       //获取待复制文件大小
       long fileSize = file.length();

        //声明一个长度为1024的数组
        byte buffer = new byte[1024];
        int readLength = 0;   //用于记录每次读取到buffer中的实际内容的长度
        while((readLength = fileInputStream.read(buffer)) != -1){
          //由于最后一次read的buffer不一定把buffer读满，所以使用能够选取写入的write方法
          fileOutputStream.write(buffer,0,readLength);
        }
        fileOutputStream.close();
        fileInputStream.close();


    字符流方法
        public static void main(String[] args) {  
          
          FileReader fr=null;//文件读出字符流对象  
          FileWriter fw=null;//文件写入字符流对象  
          try {  
              fr=new FileReader("D:\\123\\ff\\cc.txt"); //创建一个fr对象  
              fw=new FileWriter("D:\\123\\ff\\ccc.txt");  
              char[] c=new char[1024];//字符数组  
              int n=0;//记录实际读取到的字符数  
              while((n=fr.read(c))!=-1)  
              {  
                  System.out.println(c);  
                  fw.write(c,0,n);  
              }  
           } catch(Exception e)  {  
              e.printStackTrace();  
           } finally {  
              try   
              {  
                  fr.close();  
                  fw.close();  
              }   
              catch (IOException e)   
              {  
                  e.printStackTrace();  
              }  
          }  
      }
      

    按行读取
      public static void main(String[] args) throws IOException {
        long s = System.nanoTime();
        BufferedReader in = null;
        BufferedWriter out = null;
        try{
            in = new BufferedReader(new FileReader("d:/java/in.txt"));
            out = new PrintWriter("d:/java/out.txt");
            String line = null;
            while((line = in.readLine()) != null){
                out.write(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            in.close();
            out.close();
        }
      }



