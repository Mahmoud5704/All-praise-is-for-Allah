package verifies;

public class Strategy_verifier {

    private verifier strategy; 

    public Strategy_verifier(verifier strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(verifier strategy) {
        this.strategy = strategy; 
    }

    public String verify(int index) {
        if (strategy != null) {
            return strategy.checker(index); 
        }
        return "";
    }
}
