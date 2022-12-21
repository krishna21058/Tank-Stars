import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import org.junit.runner.JUnitCore;
import static org.junit.jupiter.api.Assertions.*;

class TestJunit {
    private Missile missile;
    @Test
    void checkVar(){

        assertTrue(missile.remove==false);

    }
    @Test
    void checkaccn(){
        assertTrue(Missile.acceleration==9.81);

    }

}