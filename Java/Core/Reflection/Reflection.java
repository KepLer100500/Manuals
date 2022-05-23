import java.lang.reflect.*;


public class Reflection {
    private static double testMethod(int n) {
        System.out.println("Method is called!");
        return n * 0.4;
    }

    public static void testMethod() {
        // for calling, must be public! Or have not access to this method!
        System.out.println("Method is called! This method is void!");
    }

    public static void main(String[] args) {
        // Object of class, method name, argument types, arguments 
        caller(Reflection.class, "testMethod", new Class[] {int.class}, new Object[] {5});
        rawCaller();
        simpleCallerPublicMethodWithoutArguments();
    }

    private static void caller(Class<?> clz, String methodName, Class<?>[] methodArgTypes, Object[] methodArgs) {
        try {
            Object rcvr = clz.newInstance();                    
            Method method = clz.getDeclaredMethod(methodName, methodArgTypes);
            method.setAccessible(true);
            System.out.println("Output: " + method.invoke(rcvr, methodArgs));
        } catch(NoSuchMethodException
                | IllegalArgumentException
                | InvocationTargetException
                | InstantiationException
                | SecurityException
                | IllegalAccessException err) {
            System.out.println(err);
        }
    }

    private static void rawCaller() {
        Class<?> clz = Reflection.class;
        try {
            Object rcvr = clz.newInstance();                     // create class instance
            Class<?>[] methodArgTypes = new Class[] {int.class}; // argument types
            Object[] methodArgs = {5};                           // arguments
            Method method = clz.getDeclaredMethod("testMethod", methodArgTypes); // build signature of method
            method.setAccessible(true);                          // make method accessible
            System.out.println("Output: " + method.invoke(rcvr, methodArgs));
        } catch(NoSuchMethodException
                | IllegalArgumentException
                | InvocationTargetException
                | InstantiationException
                | SecurityException
                | IllegalAccessException err) {
            System.out.println(err);
        }
    }

    private static void simpleCallerPublicMethodWithoutArguments() {
        try {
            (new Reflection()).getClass().getMethod("testMethod").invoke(new Reflection());
        } catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException err) {
            System.out.println("Method not found or you have not access to this method!");
        }
    }
}