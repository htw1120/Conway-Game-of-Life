public class PatternAcorn extends Pattern {
    PatternAcorn(){
        this.currentPattern = new boolean[][]{
                {false, true, false, false, false, false, false},
                {false, false, false, true, false, false, false},
                {true, true, false, false, true, true, true}};
    }
}
