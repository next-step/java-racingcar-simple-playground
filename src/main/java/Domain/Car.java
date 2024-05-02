package Domain;

import java.util.List;

public class Car {

    private String name;    //자동차는 이름을 가진다
    private int position;   //자동차의 현재 위치

    public Car(String name){
        this.name=name;     //이름 넣어주기
        this.position=0;    //위치 0으로 초기화
    }

    public String getName(){    //이름 반환하는 메소드
        return this.name;
    }
    public int getPosition(){   //현재 위치 반환하는 메소드
        return this.position;
    }

    public void carMoveForward(){    //앞으로 전진하는 메소드
         this.position++;
    }
    public void carMove(int randomvalue){   //랜덤 값에 따라 전진/멈춤 결정 메소드
        if(randomvalue>=4)  //4이상이면 전진
            carMoveForward();
    }
    public void setPosition(int position){  //랜덤 수에 따른 위치 저장
        this.position=position;
    }
}
