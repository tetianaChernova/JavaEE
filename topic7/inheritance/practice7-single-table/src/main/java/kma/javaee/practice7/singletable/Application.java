package kma.javaee.practice7.singletable;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import kma.javaee.practice7.singletable.entities.Animal;
import kma.javaee.practice7.singletable.entities.AnimalType;
import kma.javaee.practice7.singletable.entities.GiraffeEntity;
import kma.javaee.practice7.singletable.entities.WolfEntity;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

		AnimalService animalService = applicationContext.getBean(AnimalService.class);
		GiraffeEntity giraffe = GiraffeEntity.builder()
			.height(3.5f)
			.cageNumber("10-a")
			.name("My first giraffe")
			.build();
		giraffe = animalService.saveNewAnimal(giraffe);
		System.out.println("New giraffe: " + giraffe);

		WolfEntity wolf = WolfEntity.builder()
			.liveRegion("Siberia")
			.cageNumber("20-5")
			.name("Siberia wolf 1")
			.build();
		wolf = animalService.saveNewAnimal(wolf);
		System.out.println("New wolf: " + wolf);

		List<Animal> myZooAnimals = List.of(
			animalService.getAnimalById(1, GiraffeEntity.class),
			animalService.getAnimalById(2, WolfEntity.class)
		);

		System.out.println("My animals: " + myZooAnimals);

		System.out.println("Get all animals: " + animalService.getAllAnimals());
	}

}
