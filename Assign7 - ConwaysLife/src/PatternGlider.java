public class PatternGlider extends Pattern {
    PatternGlider() {
        this.currentPattern = new boolean[][]{
                {false, false, true},
                {true, false, true},
                {false, true, true}};
    }
}