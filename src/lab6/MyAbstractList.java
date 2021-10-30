package lab6;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0; // The size of the list

    /**
     * Create a default list
     */
    protected MyAbstractList() {
    }

    /**
     * Create a list from an array of objects
     */
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    @Override
    /** Add a new element at the end of this list */
    public void add(E e) {
        add(size, e);
    }

    @Override
    /** Return true if this list contains no elements */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    /** Return the number of elements in this list */
    public int size() {
        return size;
    }

    @Override
    /** Remove the first occurrence of the element e
     *  from this list. Shift any subsequent elements to the left.
     *  Return true if the element is removed. */
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else
            return false;
    }

    @Override
    public boolean addAll(MyList<E> otherList) {
        for (E e : otherList) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(MyList<E> otherList) {
        for (E e : otherList) {
            remove(e);
        }
        return true;
    }

    @Override
    public boolean retainAll(MyList<E> otherList) {
//    List
//    return false;

        Objects.requireNonNull(otherList);
        boolean modified = false;
        Iterator<E> it = iterator();
//    对于他的所有 如果另外一个 没有这个
        while (it.hasNext()) {
            if (!otherList.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }

        return modified;

//    Objects.requireNonNull(otherList);
//    final Object[] elementData = this.elementData;
//    int r = 0, w = 0;
//    boolean modified = false;
//    try {
////      补足
////      如果另外一个 列表 有这个数字，而且 是要补足的话
////      就 补足
//      for (; r < size; r++)
//        if (otherList.contains(elementData[r]) == complement)
//          elementData[w++] = elementData[r];
//    } finally {
//      // Preserve behavioral compatibility with AbstractCollection,
//      // even if c.contains() throws.
//      if (r != size) {
//        System.arraycopy(elementData, r,
//                elementData, w,
//                size - r);
//        w += size - r;
//      }
//      if (w != size) {
//        // clear to let GC do its work
//        for (int i = w; i < size; i++)
//          elementData[i] = null;
//        modCount += size - w;
//        size = w;
//        modified = true;
//      }
//    }
//    return modified;


    }
}
