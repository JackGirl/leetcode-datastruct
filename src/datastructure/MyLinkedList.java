package src.datastructure;


/**
 * 链表   可用双向
 * @param <E>
 */
public class MyLinkedList<E> {
    //第一个元素
    private Node <E>first;
    //最后一个元素
    private Node <E> last;
    //元素个数
    private int DATA_SIZE = 0;

    public void add(E obj){
        Node<E> elem = new Node<>();
        elem.data = obj;
        if(null==first){
            first = elem;
            last = elem;
        }else {
            last.next = elem;
            elem.prev = last;
            last = elem;
        }
        DATA_SIZE++;
    }

    /**
     * 获取节点 下标从零开始
     * @param index
     */
    private Node<E> getNode(int index){
        int i = 0;
        Node<E> node = first;
        while( i<index ){
           node = node.next;
           i++;
        }
        return node;
    }

    /**
     * 返回元素第一个出现的下标 默认从第一个开始
     * @param e
     * @return
     */
    public int get(E e){
        if(DATA_SIZE==0){
            throw new IllegalArgumentException("List is null");
        }
        Node<E> elem = first;
        int index = 0;
        while (null!=elem){
            if(elem==e)
                return index;
            if(e instanceof String &&elem.data.equals(e)){
                return index;
            }
            elem=elem.next;
            index++;
        }
        return -1;
    }

    /**
     * 获取节点元素  下标从零开始
     */
    public E get(int index){
        rangeIndex(index);
        return getNode(index).data;
    }


    /**
     * 先找到元素  然后删除
     * @param index
     */
    public void remove(int index){
        rangeIndex(index);
        Node<E> node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
        DATA_SIZE--;
    }

    /**
     * 修改下表为index 节点元素
     */
    public void set(int index,E e){
        rangeIndex(index);
        Node<E> node = getNode(index);
        node.data = e;
    }

    private void rangeIndex(int index){
        if (index<0||index>=DATA_SIZE){
            throw new  IllegalArgumentException("index out of List");
        }
    }

    /**
     * 获取元素个数
     * @return size
     */
    public int size(){
        return DATA_SIZE;
    }

    public void printElem(){
        Node<E> node = first;
        while (null != node){
            System.out.print(node.data+" ");
            node = node.next;
        }
    }

    private class Node<E>{
        Node <E> prev;
        E data;
        Node <E> next;
    }



}
