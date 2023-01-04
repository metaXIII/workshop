package com.metaxiii.fr;

import com.metaxiii.fr.model.ItemWithId;
import com.metaxiii.fr.model.ItemWithIdAndName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {
    static Logger logger = Logger.getLogger("AppTest");
    private App app;

    @BeforeAll
    public static void initAll() {
        logger.info("Start test");
    }

    @AfterAll
    public static void end() {
        logger.info("end of test");
    }

    @BeforeEach
    public void init() {
        this.app = new App();
    }

    @AfterEach
    public void endEach() {
        this.app = null;
    }

    @Test
    void seeTuplesInAction() {
        assertDoesNotThrow(() -> {
            final var tuples = app.seeTuplesInAction();
            final var itemWithId = tuples.getValue0();
            final var itemWithIdAndName = tuples.getValue1();
            assertTrue(itemWithId instanceof ItemWithId);
            assertTrue(itemWithIdAndName instanceof ItemWithIdAndName);
            assertEquals(1, itemWithId.getId());
            assertEquals(1, itemWithIdAndName.getId());
            assertEquals("item with name", itemWithIdAndName.getName());
        });

    }
}
