package model.elements;

import contract.AIType;
import contract.Direction;
import model.elements.mocks.AIMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the class AI
 */
public class AITest {

    AI t;

    @Before
    public void setUp() throws Exception {
        t = new AIMock(45,980);
    }

    @Test
    public void testGetAItTypeShouldModifyTypeOfIA() throws Exception {
        t.setAiType(AIType.DIAGONAL);
        assertEquals("The direction should change",AIType.DIAGONAL,t.getAiType());
        t.setAiType(AIType.FOLLOW);
        assertEquals("The direction should change",AIType.FOLLOW,t.getAiType());
    }
}