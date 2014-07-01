eveapi
======

A Java library for accessing EVE Online API using Square Retrofit with Simple XML processing.  

##### Simple usage example:
```
	CharApiHelper helper = new CharApiHelper(key, code);
    helper.setCharacterID(helper.getCharacters().characters.get(0).characterID);
    CharacterSheet sheet = helper.getCharacterSheet();
```
