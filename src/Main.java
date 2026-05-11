public class Main {
    public static void main(String[] args) {
        System.out.println("start of thread");

        //        calling thread1
        thread_class thread1 = new thread_class();
        thread1.start();

        //        calling thread2
        thread_interface task= new thread_interface();
        Thread thread2 = new Thread(task);
        thread2.start();

        System.out.println("end of thread");


//        Email office_mail = new Email.builder().to_builder("arunagirish.b@sap.com").from_builder("xyz@gmail.com").final_build();
//        office_mail.body_setter("updated business mail");
    }
}

