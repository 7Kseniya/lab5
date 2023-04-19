package ru.se.ifmo.lab5.utils;


import ru.se.ifmo.lab5.data.SpaceMarine;
import ru.se.ifmo.lab5.exceptions.InvalidCollectionElemId;
import ru.se.ifmo.lab5.exceptions.InvalidValueException;

import java.lang.reflect.Field;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * class describes the commands associated with the collection
 */
public class CollectionManager{
    private Integer nextId = 1;
    public LinkedHashMap<Integer, SpaceMarine> spaceMarineCollection;
    private final ZonedDateTime creationDate;

    public CollectionManager(LinkedHashMap<Integer, SpaceMarine> spaceMarineCollection, ZonedDateTime creationDate) {
        this.spaceMarineCollection = spaceMarineCollection;
        this.creationDate = ZonedDateTime.now();
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
     * insert an object of class spaceMarine into collection
     * @param id
     */
    public void insert(Integer id){
        for (SpaceMarine spaceMarine : spaceMarineCollection.values()){
            try{
                if(id == null) throw new NullPointerException();
                if(spaceMarine.getId() == null){
                    spaceMarineCollection.put(id, spaceMarine);
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
     * update an element of collection by id
     * @param id
     */
    public void update(Integer id){
        for(SpaceMarine spaceMarine : spaceMarineCollection.values()){
            try{
                if(id == null) throw new NullPointerException();
                if(spaceMarine.getId().equals(id)){
                    spaceMarineCollection.replace(id, spaceMarine);
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
                    spaceMarineCollection.remove(id);
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
                    spaceMarineCollection.remove(id);
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
                    spaceMarineCollection.remove(id);
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
    Comparator<SpaceMarine> meleeWeaponComparator = new Comparator<SpaceMarine>() {
        @Override
        public int compare(SpaceMarine o1, SpaceMarine o2) {
            return o1.getMeleeWeapon().compareTo(o2.getMeleeWeapon());
        }
    };



     //выводит элементы коллекции в порядке возрастания

    public void printAscending(){



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
        for(SpaceMarine spaceMarine :  spaceMarineCollection.values()) {
            if (spaceMarine.getId() >= nextId) {
                nextId = spaceMarine.getId();
            }
        }
        return nextId++;
    }

    /**
     * get fields of collection
     */
    public void getFields(){
        Field[] fields = spaceMarineCollection.getClass().getDeclaredFields();
        Set<String> fieldsNames = new HashSet<>();
        for (Field field : fields){
            fieldsNames.add(field.getName());
            if(fieldsNames.size() == fields.length){
                IOHandler.println("field: " + field.getName());
            }else{
                IOHandler.println("incorrect amount of fields");

            }

        }
    }



}
