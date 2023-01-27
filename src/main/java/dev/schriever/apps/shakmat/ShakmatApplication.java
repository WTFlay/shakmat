package dev.schriever.apps.shakmat;

import dev.schriever.apps.shakmat.entity.Opening;
import dev.schriever.apps.shakmat.repository.OpeningRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ShakmatApplication {

	private final static Logger log = LoggerFactory.getLogger(ShakmatApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ShakmatApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(OpeningRepository openingRepository) {
		return args -> {
			openingRepository.save(new Opening("Ouverture écossaise", "e4 e5 Cf3 Cc6 d4 exd4"));
			openingRepository.save(new Opening("Ouverture italienne", "e4 e5 Cf3 Cc6 Fc4 Fc5"));

			for (Opening opening : openingRepository.findAll()) {
				log.info(opening.getName() + ": " + opening.getMoves());
			}

			for (Opening opening: openingRepository.findByMovesStartsWith("e4 e5 Cf3 Cc6 d4")) {
				log.info("Opening start with \"e4 e5 Cf3 Cc6 d4\": " + opening.getName() + " - " + opening.getMoves());
			}

			for (Opening opening: openingRepository.findByMovesContaining("d4")) {
				log.info("Opening containing with \"d4\": " + opening.getName() + " - " + opening.getMoves());
			}
		};
	}

}
