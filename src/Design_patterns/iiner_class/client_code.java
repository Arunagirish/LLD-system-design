package Design_patterns.iiner_class;

public class client_code
{
//    rember this is the type outer_class.inner_class
//    stsic inner class
    outer_class.inner_class obj = new outer_class.inner_class();

//    non static inner class
    outer_class outer_obj = new outer_class();
    outer_class.inner_class1 inner_obj= outer_obj.new inner_class1();
}
