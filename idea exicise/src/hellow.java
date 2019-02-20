

public class hellow {
//    public static void main(String[] args) {
//        Integer i = 197;
//        Integer i1 = 197;
//        int i2 = 197;
//        int i3 = 197;
//        System.out.println(i == i1);
//        System.out.println(i2 == i3);
//        System.out.println(i == i2);
//        StringBuffer sb = new StringBuffer("abc");
//        String adb = "1";
//        String asd = adb + "c";
//        asd.isEmpty();
//
//
//    }
}

    interface Inter {
        public void show1();

        public void show2();
    }

    //匿名内部类只针对重写一个方法时候使用
    class Outer {
        public void method() {
        /*new Inter(){
            public void show1() {
                System.out.println("show1");
            }

            public void show2() {
                System.out.println("show2");
            }
        }.show1();

        new Inter(){
            public void show1() {
                System.out.println("show1");
            }

            public void show2() {
                System.out.println("show2");
            }
        }.show2();*/

            Inter i = new Inter() {
                public void show1() {
                    System.out.println("show1");
                }

                public void show2() {
                    System.out.println("show2");
                }

            public void show3() {
                System.out.println("show3");
            }
            };

            i.show1();
            i.show2();
            //i.show3();                        //匿名内部类是不能向下转型的,因为没有子类类名
        }
    }
