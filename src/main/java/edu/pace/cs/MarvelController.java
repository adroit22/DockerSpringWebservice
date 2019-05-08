package edu.pace.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarvelController {

	@Autowired
	private MarvelService marvelService;

	@RequestMapping(value = "/marvel/characters", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMarvelCharacters() {
		return ResponseEntity.ok().body(marvelService.getAllMarvelCharacters());
	}

	@RequestMapping(value = "/marvel/characters/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCharacter(@PathVariable("id") String id) {
		if (MarvelService.isStringInteger(id)) {
			Character marvelCharacter = marvelService.getCharacter(Integer.parseInt(id));
			if (marvelCharacter != null) {
				return ResponseEntity.ok().body(marvelCharacter);
			}
			return ResponseEntity.ok().body("No marvel charcter found with id " + id + ". Try ids between 1-18");
		}

		return ResponseEntity.ok().body("Non Integer Ids are not allowed!");
	}

}
