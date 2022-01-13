public class ConsoleOutput implements Output{

    public static final String RESULT_MESSAGE = "결과 = ";

    @Override
    public void showResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }

}
