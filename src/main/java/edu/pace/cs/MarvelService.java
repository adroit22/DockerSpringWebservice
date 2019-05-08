package edu.pace.cs;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MarvelService {

	private static Map<Integer, Character> idToCharacterMap = new HashMap<>();

	@PostConstruct
	public void populateList() throws IOException {

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("marvel.json")) {

			String content = IOUtils.toString(inputStream);
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			List<Character> characterList = mapper.readValue(content, new TypeReference<List<Character>>() {
			});
			characterList.forEach(e -> {
				idToCharacterMap.put(e.getId(), e);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public MarvelCharacters getAllMarvelCharacters() {
		MarvelCharacters characters = new MarvelCharacters();
		characters.setMarvelCharacters(new ArrayList<>(idToCharacterMap.values()));
		return characters;
	}

	public Character getCharacter(Integer id) {
		if (idToCharacterMap.containsKey(id)) {
			return idToCharacterMap.get(id);
		}
		return null;
	}
	
	public static boolean isStringInteger(String number ){
	    try{
	        Integer.parseInt(number);
	    }catch(Exception e ){
	        return false;
	    }
	    return true;
	}

}
