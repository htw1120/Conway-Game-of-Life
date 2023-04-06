public class PatternBlinker extends Pattern {
    PatternBlinker(){
        this.currentPattern = new boolean[][]{
                {false, false, false},
                {true, true, true},
                {false, false, false}};
    }
}
