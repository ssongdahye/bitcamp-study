// 오버라이딩(overriding) - 오버라이딩을 하는 이유?
package com.eomcs.oop.ex06.c;

class Score {

  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;

  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}

class Score2 extends Score {
  protected int music;
  protected int art;
}

public class Exam0010 {
  public static void main(String[] args) {

    Score2 score = new Score2();

    score.kor = 100;
    score.eng = 100;
    score.math = 100;
    score.music = 50;
    score.art = 50;

    score.compute();

    System.out.printf("%d(%f)\n", score.sum, score.aver);

    // 합계와 평균이 틀린 이유?
    // - 새로 추가한 필드에 맞춰 계산을 해야 하는데
    //   수퍼클래스의 compute() 메서드는
    //   음악(music)과 미술(art) 점수를 고려하지 않고
    //   기존 방식으로 계산하기 때문에
    //   합계와 평균이 올바르게 계산되지 않는다.
  }
}
