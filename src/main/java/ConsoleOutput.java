public class ConsoleOutput implements Output{

    @Override
    public void showResult(int result) {
        System.out.println("결과 = " + result);
    }

}
