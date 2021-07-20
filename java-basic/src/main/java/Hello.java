class Hello {
  // --------------------------------------
  // | main()                             |
  // |- 프로그램 실행 시작점              |
  // |- 'entry point'라 부름              |
  // --------------------------------------
  public static void main(String[] args){
    System.out.println("Hello, world!");
    System.out.println("안녕하세요!");

    int a = 20;
    int b = ++a;

    System.out.println(a);
    System.out.println(b);

    String s4 = "30";

    int i = 20;

    System.out.println(s4 + i);
  }
}