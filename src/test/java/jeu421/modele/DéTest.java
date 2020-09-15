package jeu421.modele;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Random ;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DéTest {
    @Mock
    Random random;
    Dé unDé;
    int [] valeurs = {1, 2, 3, 4, 5, 0};

    @BeforeEach
    public void setUp() throws Exception {
        unDé = new Dé();
    }

    @Test
    public void lancer() throws Exception {
        int résultatDuDé = unDé.lancer();
        assertTrue(résultatDuDé >= 1, "le résultat est plus grand ou égal que 1");
        assertTrue(résultatDuDé <= 6, "le résultat est plus petit ou égal que 6");
    }

    @Test
    public void lancerAvecMockito() throws Exception {
        when(random.nextInt(anyInt())).thenReturn(1, 2, 3, 4, 5, 0);

        unDé.affecterGénérateur(random);
        for(int i = 0; i < 6; i++) {
            int résultatDuDé = unDé.lancer();
            assertEquals(valeurs[i]+1, résultatDuDé, "le résultat est "+valeurs[i]+1);
            assertTrue(résultatDuDé >= 1, "le résultat est plus grand ou égal que 1");
            assertTrue(résultatDuDé <= 6,"le résultat est plus petit ou égal que 6");
        }
    }



}