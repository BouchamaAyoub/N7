import java.awt.Color;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/** Classe de tests exhaustifs de la classe Cercle
 * 
 * @author Ayoub Bouchama <ayoub.bouchama@etu.toulouse-inp.fr>
 */

public class ComplementsCercleTest {

        // précision pour les comparaisons réelle
        public final static double EPSILON = 0.001;

        // Les centres du sujet
        Point centre;
        Point p1;
        Point p2;
        
        // Les cercles du sujet
        Cercle C1;
        Cercle C2;
        Cercle C3;
        
        // Le rayon du sujet
        double rayon;
        
        @Before public void setUp() {
                
                // Initialiser les points du test
                centre 	= 	new Point(0, 0);
                p1 		= 	new Point(0, 0);
                p2 		= 	new Point(10, 0);
                
                // Initialiser le rayon
                rayon            =       5;

                // Initialiser les cercles du test
                C1               =       new Cercle(centre, rayon);
                C2               =       new Cercle(p1, p2);
                C3               =       new Cercle(p1, p2, Color.RED);

        }

        /** Tester le premier constructeur de la classe cercle à partir du centre et du rayon
         * 1er test     :       paramètre valide (centre et rayon)
         * 2ème test    :       paramètre invalide (rayon = -1 < 0)
         * 3ème test    :       paramètre invalide (rayon = 0 < 0)
         * 4ème test    :       paramètre invalide (centre = null)
         */
        @Test
        public void testCercleConstructeur() {
         
                // Test pour une valeur positive valide
                assertEquals(centre, C1.getCentre());
                assertEquals(rayon, C1.getRayon(), EPSILON);
  
                // Test pour une valeur négative
                try {
                        C1 = new Cercle(centre, -1);
                        fail("Une exception devrait être levée pour une valeur de rayon négative");
                } 
                catch (AssertionError e) {
                        // Attendue exception pour une valeur de rayon négative
                }
  
                // Test pour une valeur nulle
                try {
                        C1 = new Cercle(centre, 0);
                        fail("Une exception devrait être levée pour une valeur de rayon nulle");
                } 
                catch (AssertionError e) {
                        // Attendue exception pour une valeur de rayon nulle
                }
  
                // Test pour un centre nul
                try {
                        C1 = new Cercle(null, rayon);
                        fail("Une exception devrait être levée pour un centre nul");
                } 
                catch (AssertionError e) {
                        // Attendue exception pour un centre nul
                }
        }

        /** Tester le deuxième constructeur de la classe cercle à partir de deux point diamètralement opposés
         * 1er test     :       paramètre valide (p1 et p2)
         * 2ème test    :       paramètre invalide (p1 = null)
         * 3ème test    :       paramètre invalide (p2 = null)
         * 4ème test    :       paramètre invalide (p1 = p2)
         */
        @Test
        public void testCercleConstructeur2Points() {
               
                // Test pour des points valides
                assertEquals(5, C2.getRayon(), EPSILON);
                assertEquals(5, C2.getCentre().getX(), EPSILON);
                assertEquals(0, C2.getCentre().getY(), EPSILON);
                assertEquals(Color.BLUE, C2.getCouleur());
                
                // Test pour p1 null
                try {
                        C2 = new Cercle(null, p2);
                        fail("Une exception devrait être levée pour un point nul");
                } catch (AssertionError e) {
                        // Attendue exception pour un point nul
                }
                
                // Test pour p2 null
                try {
                        C2 = new Cercle(p1, null);
                        fail("Une exception devrait être levée pour un point nul");
                } catch (AssertionError e) {
                        // Attendue exception pour un point nul
                }
                
                // Test pour des points identiques
                try {
                        C2 = new Cercle(p1, p1);
                        fail("Une exception devrait être levée pour des points identiques");
                } 
                catch (AssertionError e) {
                        // Attendue exception pour des points identiques
                }
        }

        /** Tester le troisième constructeur de la classe cercle à partir de deux point diamètralement opposés et sa couleur
         * 1er test     :       paramètre valide (p1 et p2)
         * 2ème test    :       paramètre invalide (p1 = null)
         * 3ème test    :       paramètre invalide (p2 = null)
         * 4ème test    :       paramètre invalide (p1 = p2)
         * 5ème test    :       paramétre invalide (couleur = null)
         */
        @Test
        public void testCercleConstructeur2PointsEtCouleur() {

                // Test pour des points valides
                assertEquals(5, C3.getRayon(), EPSILON);
                assertEquals(5, C3.getCentre().getX(), EPSILON);
                assertEquals(0, C3.getCentre().getY(), EPSILON);
                assertEquals(Color.RED, C3.getCouleur());
                
                // Test pour p1 null
                try {
                        C3 = new Cercle(null, p2, Color.RED);
                        fail("Une exception devrait être levée pour un point nul");
                } catch (AssertionError e) {
                        // Attendue exception pour un point nul
                }
                
                // Test pour p2 null
                try {
                        C3 = new Cercle(p1, null, Color.RED);
                        fail("Une exception devrait être levée pour un point nul");
                } catch (AssertionError e) {
                        // Attendue exception pour un point nul
                }
                
                // Test pour des points identiques
                try {
                        C3 = new Cercle(p1, p1, Color.RED);
                        fail("Une exception devrait être levée pour des points identiques");
                } 
                catch (AssertionError e) {
                        // Attendue exception pour des points identiques
                }

                // Test pour une couleur nulle
                try {
                        C3 = new Cercle(p1, p2, null);
                        fail("Une exception devrait être levée pour une couleur nulle");
                } 
                catch (AssertionError e) {
                        // Attendue exception pour une couleur nulle
                }
        }

        /** Tester la methode translater
         * 1er test     :       Avec des translations positives (dx = 2, dy = 3)
         * 2ème test    :       Avec des translations negatives (dx = -2, dy = -3)
         */
        @Test
        public void testTranslater() {

                // Test translation valide
                C1.translater(2, 3);
                assertEquals(2, C1.getCentre().getX(), EPSILON);
                assertEquals(3, C1.getCentre().getY(), EPSILON);
            
                // Test translation négative
                C1.translater(-4, -6);
                assertEquals(-2, C1.getCentre().getX(), EPSILON);
                assertEquals(-3, C1.getCentre().getY(), EPSILON);
        }

        /** Tester la methode getCentre
         * 1er test     :       Recupérer le centre de C1
         * 2ème test    :       Translater le centre du cercle C1 puis recupérer le nouveau centre
         */
        @Test
        public void testGetCentre() {

                Point centreAttendu = new Point(2,2);
 
                // Tester getCentre
                assertEquals(centre, C1.getCentre());
                
                // Translater le centre puis tester getCentre
                C1.translater(2, 2);
                assertEquals(centreAttendu.getX(), C1.getCentre().getX(), EPSILON);
                assertEquals(centreAttendu.getY(), C1.getCentre().getY(), EPSILON);
        }

        /** Tester la methode getRayon
         * 1er test     :       Recupérer le rayon de C1
         * 2ème test    :       Modifier le rayon de C1 puis recupérer le nouveau rayon
         */
        @Test
        public void testGetRayon() {

                // Tester getRayon
                assertEquals(rayon, C1.getRayon(), EPSILON);
                
                // Modifier le rayon puis tester getRayon
                C1.setRayon(20);
                assertEquals(20, C1.getRayon(), EPSILON);
        }

        /** Tester la methode getDiametre
         * 1er test     :       Recupérer le diametre de C1
         * 2ème test    :       Modifier le diamètre de C1 puis recupérer le nouveau diamètre
         */
        @Test
        public void testGetDiametre() {

                // Tester getDiametre
                assertEquals(10, C1.getDiametre(), EPSILON);
                
                // Modifier le rayon puis tester getDiametre
                C1.setRayon(20);
                assertEquals(40, C1.getDiametre(), EPSILON);
        }

        /** Tester la methode contient qui indique si un point est contenu dans le cercle ou pas
         * 1er test     :       paramètre valide (pointInterieur != null)
         * 2ème test    :       paramètre valide (pointExterieur != null)
         * 3ème test    :       paramètre invalide (un point nul)
         */
        @Test
        public void testContient() {
               
                // Initialiser les paramétres
                Point pointInterieur = new Point(2, 2);
                Point pointExterieur = new Point(7, 7);

                // Test avec un point à l'intérieur du cercle
                assertTrue(C1.contient(pointInterieur));
                assertFalse(C1.contient(pointExterieur));

                try {
                        assertTrue(C1.contient(null));
                        fail("Une exception devrait être levée pour un point null");
                }
                catch (AssertionError e) {
                // Attendue exception pour un point null
                }
        }

        /** Tester la methode perimetre qui retourne le perimetre d'un cercle
         * Tests : Recupérer les perimètres de C1, C2 et C3
         */
        @Test
        public void testPerimetre() {

                // Tester la methode perimetre
                assertEquals(31.415926, C1.perimetre(), EPSILON);
                assertEquals(31.415926, C2.perimetre(), EPSILON);
                assertEquals(31.415926, C3.perimetre(), EPSILON);
        }

        /** Tester la methode aire qui retourne l'aire d'un cercle
         * Tests : Recupérer les aires de C1, C2 et C3
         */
        @Test
        public void testAire() {

                // Tester la methode perimetre
                assertEquals(78.539816, C1.aire(), EPSILON);
                assertEquals(78.539816, C2.aire(), EPSILON);
                assertEquals(78.539816, C3.aire(), EPSILON);
        }

        /** Tester la methode getCouleur qui récupère la couleur d'un cercle
         * Tests : Recupérer les couleurs de C1, C2 et C3
         */
        @Test
        public void testGetCouleur() {

                // Tester la methode getCouleur sur les cercles C1, C2 et C3
                assertEquals(Color.BLUE, C1.getCouleur());
                assertEquals(Color.BLUE, C2.getCouleur());
                assertEquals(Color.RED, C3.getCouleur());
        }

        /** Tester la methode setCouleur qui modifie la couleur d'un cercle
         * 1er test     :       Modifier la couleur du cercle C1 et la vérifier (paramètre valide)
         * 2ème test    :       Modifier la couleur du cercle C2 et la vérifier (paramètre invalide)
         * 3ème test    :       Utiliser la methode setCouleur avec une couleur nul (paramètre invalide)
         */
        @Test
        public void testSetCouleur() {

                // Tester setCouleur avec une couleur valide
                C1.setCouleur(Color.GREEN);
                assertEquals(Color.GREEN, C1.getCouleur());
                C2.setCouleur(Color.RED);
                assertEquals(Color.RED, C2.getCouleur());

                // Tester setCouleur avec une entrée nulle
                try {
                        C3.setCouleur(null);
                        fail("Une exception devrait être levée pour une couleur nulle");
                } 
                catch (AssertionError e) {
                        // Attendue exception pour une couleur nulle
                }
        }

        /** Tester la methode creerCercle qui crée un cercle à partir du point p1 constituant le centre du cercle et p2 un point appartenant au cercle
         * 1er test     :       Paramètres valides (p1 et p2)
         * 2ème test    :       Paramètres invalides (p1 = p2)
         * 3ème test    :       Paramètre invalide (p1 = null)
         * 4ème test    :       Paramètre invalide (p2 = null)
         */
        @Test
        public void testCreerCercle() {

                // Test pour des points valides
                Cercle cercle = Cercle.creerCercle(p1, p2);
                assertEquals(p1, cercle.getCentre());
                assertEquals(p1.distance(p2), cercle.getRayon(), EPSILON);

                // Test pour des points identiques
                try {
                        cercle = Cercle.creerCercle(p1, p1);
                        fail("Une exception devrait être levée pour des points identiques");
                }
                catch (AssertionError e) {
                        // Attendue exception pour des points identiques
                }
                
                // Test pour p1 = null
                try {
                        cercle = Cercle.creerCercle(null, p2);
                        fail("Une exception devrait être levée pour un point null");
                }
                catch (AssertionError e) {
                // Attendue exception pour un point null
                }

                // Test pour p2 = null
                try {
                        Cercle.creerCercle(p1, null);
                        fail("Une exception devrait être levée pour un point null");
                }
                catch (AssertionError e) {
                        // Attendue exception pour un point null
                }
        }

        /** Tester la methode toString qui affiche un cercle de la forme Cr@(x, y)
         * Tests : Afficher les trois cercle C1, C2 et C3
         */
        @Test
        public void testToString() {

                // Tester la methode toString.
                assertEquals("C5.0@(0.0, 0.0)", C1.toString());
                assertEquals("C5.0@(5.0, 0.0)", C2.toString());
                assertEquals("C5.0@(5.0, 0.0)", C3.toString());
        }

        /** Tester la méthode SetRayon qui modifie le rayon d'un cercle
         * 1er test     :       Paramètre valide (rayon = 10)
         * 2ème test    :       Paramètre invalide (rayon = -1)
         * 3ème test    :       Paramètre invalide (rayon = 0)
         */
        @Test
        public void testSetRayon() {

                // Test pour une valeur positive valide
                C1.setRayon(10);
                assertEquals(10, C1.getRayon(), EPSILON);

                // Test pour une valeur négative
                try {
                        C1.setRayon(-1);
                        fail("Une exception devrait être levée pour une valeur de rayon négative");
                }
                catch (AssertionError e) {
                // Attendue exception pour une valeur de rayon négative
                }

                // Test pour une valeur nulle
                try {
                        C1.setRayon(0);
                        fail("Une exception devrait être levée pour une valeur de rayon nulle");
                }
                catch (AssertionError e) {
                // Attendue exception pour une valeur de rayon nulle
                }
        }

        /** Tester la méthode SetDiametre qui modifie le diamètre d'un cercle
         * 1er test     :       Paramètre valide (diamètre = 20)
         * 2ème test    :       Paramètre invalide (diamètre = -2)
         * 3ème test    :       Paramètre invalide (diamètre = 0)
         */
        @Test
        public void testSetDiametre() {
                Cercle cercle = new Cercle(centre, rayon);

                // Test pour une valeur positive valide
                cercle.setDiametre(20);
                assertEquals(10, cercle.getRayon(), EPSILON);

                // Test pour une valeur négative
                try {
                        cercle.setDiametre(-2);
                        fail("Une exception devrait être levée pour une valeur de diamètre négative");
                }
                catch (AssertionError e) {
                        // Attendue exception pour une valeur de diamètre négative
                }

                // Test pour une valeur nulle
                try {
                        cercle.setDiametre(0);
                        fail("Une exception devrait être levée pour une valeur de diamètre nulle");
                }
                catch (AssertionError e) {
                        // Attendue exception pour une valeur de diamètre nulle
                }
        }
        

}