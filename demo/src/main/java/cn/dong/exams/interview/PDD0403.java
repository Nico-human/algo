package cn.dong.exams.interview;

/**
 * @author dongzhenxun
 * @date 2025/4/3 下午8:55
 * @description PDD面试，手撕单例模式，
 *                      斐波那契数列（LC 509），
 *                      判断链表是否相交（LC 160）
 */
public class PDD0403 {

    // 饿汉式：类加载时就创建，线程安全，但可能浪费资源
    // public class SingleTon {
    //     private static final SingleTon instance = new SingleTon();
    //     private SingleTon () {}
    //     public static SingleTon getInstance() { return instance};
    // }

    // 懒汉式：懒加载，在需要时才创建实例，需要处理线程安全问题 （DCL双重检查锁）
    // public class Singleton {
    //    // volatile关键字禁止指令重排序，确保线程之间的内存可见性
    //    private static volatile Singleton instance;
    //    private Singleton () {}
    //    // 双重校验（Double-checked lock）确保线程安全
    //    public static Singleton getInstance() {
    //        if (instance == null) {
    //            synchronized (Singleton.class) {
    //                if (instance == null) {
    //                    instance = new Singleton();
    //                }
    //                return instance;
    //            }
    //        }
    //        return instance;
    //    }
    //}

    // （实际生产用这个） 静态内部类：利用类加载机制，实现懒加载，同时保证线程安全
    // public class Singleton {
    // // 私有构造器
    // private Singleton () {}
    // // 私有静态内部类中的静态成员属性
    // private static class SingletonHolder {
    //     private static final Singleton instance = new Singleton();
    // }
    // // 静态方法暴露给外部调用
    // public static Singleton getInstance() {
    //     return SingletonHolder.instance;
    // }
    //}


}
