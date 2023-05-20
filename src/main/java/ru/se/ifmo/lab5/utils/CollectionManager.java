package ru.se.ifmo.lab5.utils;

import ru.se.ifmo.lab5.data.MeleeWeapon;
import ru.se.ifmo.lab5.data.SpaceMarine;
import ru.se.ifmo.lab5.exceptions.InvalidCollectionElemId;
import ru.se.ifmo.lab5.exceptions.InvalidValueException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * class describes the commands associated with the collection
 */
public class CollectionManager{
    private Integer nextId = 1;
    private LinkedHashMap<Integer, SpaceMarine> spaceMarineCollection;
    private final ZonedDateTime creationDate;

    public CollectionManager(LinkedHashMap<Integer, SpaceMarine> spaceMarineCollection, ZonedDateTime creationDate) {
        this.creationDate = ZonedDateTime.now();
        this.spaceMarineCollection = spaceMarineCollection;
    }

    public LinkedHashMap<Integer, SpaceMarine> getSpaceMarineCollection() {
        return spaceMarineCollection;
    }

    /**
     * format creation date and output it as string
     * @return formatted creation date
     */
    public String getCreationDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = creationDate.format(formatter);
        return formattedDate;
    }

    /**
     * outputs all collection elements
     */
    public void show(){
        for(SpaceMarine spaceMarine : spaceMarineCollection.values()){
            IOHandler.println(spaceMarine.toString());
        }
    }
    /**
     * update an element of collection by id
     * @param id
     */
    public void update(Integer id){
        for(SpaceMarine spaceMarine : spaceMarineCollection.values()){
            try{
                if(id == null) throw new NullPointerException();
                if(spaceMarine.getId().equals(id)){
                    this.spaceMarineCollection.replace(id, spaceMarine);
                    IOHandler.println("collection element updated successfully");
                }else{
                    throw new InvalidCollectionElemId();
                }
            }catch (InvalidCollectionElemId e){
                IOHandler.println("there is no element with that id");
            }catch (NullPointerException e){
                IOHandler.println("specified id is null");
            }
        }
    }
    /**
     * remove an element from collection by id
     * @param id
     */
    public void removeById(Integer id){
        for(SpaceMarine spaceMarine : spaceMarineCollection.values()){
            try{
                if(id == null) throw new NullPointerException();
                if(spaceMarine.getId().equals(id)){
                    this.spaceMarineCollection.remove(id);
                }else{
                    throw new InvalidCollectionElemId();
                }
            }catch (InvalidCollectionElemId e){
                IOHandler.println("there is no element with that id");
            }catch (NullPointerException e){
                IOHandler.println("specified id is null");
            }
        }
    }
    /**
     * remove elements from collection whose id greater than given
     * @param id
     */
    public void removeGreater(Integer id){
        for(SpaceMarine spaceMarine : spaceMarineCollection.values()){
            try{
                if(id == null) throw new NullPointerException();
                if(spaceMarine.getId() > id){
                    this.spaceMarineCollection.remove(id);
                    IOHandler.println("element removed");
                }else{
                    throw new InvalidCollectionElemId();
                }
            }catch (InvalidCollectionElemId e){
                IOHandler.println("there is no element with that id");
            }catch (NullPointerException e){
                IOHandler.println("specified id is null");
            }

        }
    }
    /**
     * remove elements from collection whose id lower than given
     * @param id
     */
    public void removeLower(Integer id){
        for(SpaceMarine spaceMarine : spaceMarineCollection.values()){
            try{
                if(id == null) throw new NullPointerException();
                if(spaceMarine.getId() < id){
                    this.spaceMarineCollection.remove(id);
                    IOHandler.println("element removed");
                }else{
                    throw new InvalidCollectionElemId();
                }
            }catch (InvalidCollectionElemId e){
                IOHandler.println("there is no element with that id");
            }catch (NullPointerException e){
                IOHandler.println("specified id is null");
            }
        }
    }

    /**
     * outputs all elements of collection whose health equals specified health
     * @param health
     */
    public void filterByHealth(Integer health){
        for(SpaceMarine spaceMarine : spaceMarineCollection.values()){
            try{
                if(health == null) throw new NullPointerException();
                if(health <= 0) throw new InvalidValueException();
                if(spaceMarine.getHealth().equals(health))
                    IOHandler.println(spaceMarine);
            }catch (NullPointerException e){
                IOHandler.println("specified health value is null");
            } catch (InvalidValueException e) {
                IOHandler.println("'health' must be over 0");
            }
        }
    }
/*    Comparator<SpaceMarine> meleeWeaponComparator = new Comparator<SpaceMarine>() {
        @Override
        public int compare(SpaceMarine o1, SpaceMarine o2) {
            return o1.getMeleeWeapon().compareTo(o2.getMeleeWeapon());
        }
    };*/


    /**
     * show collection elements in ascending order
     */
    public void printAscending(){
        spaceMarineCollection.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .forEach(entry -> IOHandler.println(entry.getValue()));
    }

    /**
     * get collection element with max value of melee weapon
     */
    public void maxByMeleeWeapon() {
        if (spaceMarineCollection.isEmpty()) {
            IOHandler.println("collection is empty");
        }
        MeleeWeapon maxMeleeWeapon = null;
        for (SpaceMarine spaceMarine : spaceMarineCollection.values()) {
            if (maxMeleeWeapon == null || spaceMarine.getMeleeWeapon().compareTo(maxMeleeWeapon) > 0) {
                maxMeleeWeapon = spaceMarine.getMeleeWeapon();
            }
        }
        SpaceMarine marine = null;
        for (SpaceMarine spaceMarine : spaceMarineCollection.values()) {
            if (spaceMarine.getMeleeWeapon().equals(maxMeleeWeapon)) {
                marine = spaceMarine;
                break;
            }
        }
        IOHandler.println(marine);
    }


    /**
     * save collection to file
     */
    public void save(String fileName){
        File outputFile = new File(fileName);
        try {
            StringBuilder csv = new StringBuilder();
            for (SpaceMarine spaceMarine : spaceMarineCollection.values()) {
                String[] row = spaceMarine.getValues();
                csv.append(String.join(",", row));
                csv.append("\n");
            }
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile));
            output.write(String.join("", csv).getBytes(StandardCharsets.UTF_8));
            output.close();
        } catch (IOException e){
            IOHandler.println("unable to save collection to file");
        }
    }

    /**
     * clear collection
     */
    public void clear(){
        spaceMarineCollection.clear();
    }

    public LinkedHashMap<Integer, SpaceMarine> getCollection(){
        return spaceMarineCollection;
    }
    public int getSize(){
        return spaceMarineCollection.size();
    }
    public Integer generateNextId(){
        for(SpaceMarine spaceMarine : spaceMarineCollection.values()) {
            if (spaceMarine.getId() >= nextId) {
                nextId = spaceMarine.getId();
            }
        }
        return nextId++;
    }

    /**
     * get fields of collection
     */
/*    public void getFields(){
        Field[] fields = spaceMarineCollection.getClass().getDeclaredFields();
        Set<String> fieldsNames = new HashSet<>();
        for (Field field : fields) {
            fieldsNames.add(field.getName());
        }
        if (fieldsNames.size() == fields.length) {
            for (Field field : fields) {
                IOHandler.println("field: " + field.getName());
            }
        } else {
            IOHandler.println("incorrect amount of fields");
        }
    }*/
}
