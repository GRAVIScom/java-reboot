package ru.sberbank.edu;

import java.util.*;


public class CustomArrayImpl<T> implements CustomArray<T>{

    private final ArrayList<T> arrayList;

    Object[] contains;

    private static final int DEFAULT_SIZE = 10;

    public CustomArrayImpl(int size) {
        this.arrayList = new ArrayList<>(size);
        this.contains = new Object[size];
    }

    public CustomArrayImpl() {
        this.arrayList = new ArrayList<>(DEFAULT_SIZE);
        this.contains = new Object[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return this.arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    /**
     * Add single item.
     *
     * @param item
     */
    @Override
    public boolean add(T item) {
        this.arrayList.add(item);
        return true;
    }

    /**
     * Add all items.
     *
     * @param items
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public boolean addAll(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException("parameter items is cant be null");
        }
        else {
            arrayList.addAll(Arrays.asList(items));
            return true;
        }
    }

    /**
     * Add all items.
     *
     * @param items
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public Object[] addAll(Collection<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("parameter items is cant be null");
        } else {
            arrayList.addAll(items);
        }
        return items.toArray();
    }

    /**
     * Add items to current place in array.
     *
     * @param index - index
     * @param items - items for insert
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * @throws IllegalArgumentException       if parameter items is null
     */
    @Override
    public boolean addAll(int index, T[] items) {
        if (items == null) {
            throw new IllegalArgumentException("parameter items is cant be null");
        }
        else if (index > arrayList.size()){
            throw new ArrayIndexOutOfBoundsException("index is out of bounds");
        }
        else {
            arrayList.addAll(index, List.of(items));
            return true;
        }
    }

    /**
     * Get item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public T get(int index) {
        if (index > arrayList.size()){
            throw new ArrayIndexOutOfBoundsException("index is out of bounds");
        }
        return arrayList.get(index);
    }

    /**
     * Set item by index.
     *
     * @param index - index
     * @param item
     * @return old value
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public T set(int index, T item) {
        T oldItem = null;
        if (index > arrayList.size()){
            throw new ArrayIndexOutOfBoundsException("index is out of bounds");
        }
        else {
            oldItem = arrayList.get(index);
            arrayList.set(index,item);
        }
        return oldItem;
    }

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public void remove(int index) {
        if (index > arrayList.size()){
            throw new ArrayIndexOutOfBoundsException("index is out of bounds");
        }
        else {
            arrayList.remove(index);
        }
    }

    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    @Override
    public boolean remove(T item) {
        int count = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == item) {
                arrayList.remove(i);
                count++;
            }
        }
        if (count>0)
            return true;
        else
            return false;
    }

    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false
     */
    @Override
    public boolean contains(T item) {
        return arrayList.contains(item);
    }

    /**
     * Index of item.
     *
     * @param item - item
     * @return index of element or -1 of list doesn't contain element
     */
    @Override
    public int indexOf(T item) {
        return arrayList.indexOf(item);
    }

    /**
     * Grow current capacity to store new elements if needed.
     *
     * @param newElementsCount - new elements count
     */
    @Override
    public void ensureCapacity(int newElementsCount) {
        if (arrayList.size() < newElementsCount)
            arrayList.ensureCapacity(newElementsCount);
    }

    /**
     * Get current capacity.
     */
    @Override
    public int getCapacity() {
        return this.contains.length;
    }

    /**
     * Reverse list.
     */
    @Override
    public void reverse() {
        Collections.reverse(arrayList);
    }

    /**
     * Get copy of current array.
     */
    @Override
    public Object[] toArray() {
        return arrayList.toArray();
    }
}
