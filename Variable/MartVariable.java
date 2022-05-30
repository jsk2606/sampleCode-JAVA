
public class MartVariable {//마트 스코프 시작

    /**
     'int'      라는 '기본형' 타입의 'cart'      라는 이름을 가진 변수
     'String' 이라는 '참조형' 타입의 'reference' 라는 이름을 가진 변수
     */
    static int     cart;
    static String  reference;

    public static void main(String[] args){
        /**
         스코프 에러 !
         food           = 1;
         homeAppliances = 1;
         dress          = 1;
         */
        cart = 1;
        float f = 100.0F;   //100.0 뒤에 붙은 'F' 는 값이 'float' 타입이라는 뜻이다.

        /**
         타입변환-자동
         명시적으로 쓴다면 다음과 같다.
         f = (float) cart + f;
         */
        f = cart + f;

        /**
         타입변환-명시적
         */
        cart = (int)f;

        /**
         변환 에러 !
         변수에 대입하는 값의 타입이 더 큰 비트일때 명시적 변환을 하지 않으면 오류가 발생한다.
         cart = f;  --> ERROR
         */
    }

    public void floor1()
    {/** floor1 스코프의 시작 */
        int food;
        cart = 1;
    }/** floor1 스코프의 종료 */

    public void floor2(){
        int homeAppliances;
        cart = 2;
    }

    public void floor3(){
        int dress;
        cart = 3;
    }

}//마트 스코프 종료료
