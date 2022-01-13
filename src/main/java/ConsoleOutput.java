public class ConsoleOutput extends GameOutput {

    @Override
    protected void output(String message) {
        System.out.println(message);
    }

}
