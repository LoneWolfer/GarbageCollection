
public class Main {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();     //获得运行时的环境
        //获得并打印循环前的可用内存
        long free = runtime.freeMemory()/1024;
        System.out.println("循环前可用内存： " + free + "KB");
        for (int i =1; i <= 100000; i++){
            Person p = new Person("Tom");
            //每创建2000个对象请求一次垃圾回收
            if (i%2000 == 0){
                System.gc();              //请求垃圾回收
            }
            //创建80000个对象后，获得并打印当前可用内存
            if (i == 80000){
                free = runtime.freeMemory()/1024;
                System.out.println("循环到第80000次时的可用内存： " + free + "KB");
                break;
            }
        }
    }
}
