# Glossaire

microservice: Stucture d'application qui va créer des microservice indépandant mais qui vont pouvoir communiquer les uns avec les autres. 

pom.xml: Va permettre de gerer notre projet java avec les versions, les dépandances...

Spring Boot: Spring Boot est un framework qui va facilite le développement d'applications en offrant des outils permettant d'obtenir une application packagée en jar , totalement autonome.

Controleur: Va nous permettre de traiter les requetes ainsi que la donnée qui est envoyé.

@Mapping: Pour créer nos route avec url et methodes GET,POST,PUT... Le CRUD quoi

Model: Gerer la structure de nos éléments avec des propriétés definie, puis l'accessibilité avec des getteurs et setters.

Thymeleaf: Un moteur de template pour java qui va permettre de rejouter des vue a notre projet

Thymeleaf Marker: instruction pour combiner les donnée de java et les vues de thymeleaf

@RestController: Va s'occuper de gerer les routes et les reponses

@RequestMapping: Précise quelle méthode doit être appelée pour une URI donnée.

@ResponseBody: Va convertir la reponse http

@PathVariable: Indique qu'un paramètre de méthode doit être lié à une variable de modèle d'URI.

@Service: Permet de déclarer un bean de service

@Repository: Indique que la classe est un référentiel. Un référentiel est un mécanisme d'encapsulation du comportement de stockage, d'extraction et de recherche qui émule une collection d'objets

@Autowired: Inject une dependance qui est dans le projet

@EnableSwagger2: Porte bien son nom va rendre swagger utilisable sur notre API Rest

@Bean Execute cette methode et elle sera appellé qu'une seule fois, si on en a besoin on a juste a l'autowired. 