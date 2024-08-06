package dsa;
//import java.util.*;
class LinkedList
{
	private Node head;
	private Node tail;
	private int length;
	
	class Node
	{
		int value;
		Node next;
		Node(int value)
		{
			this.value=value;
		}
	}
	LinkedList(int value)
	{
		Node newNode=new Node(value);
		head=newNode;
		tail=newNode;
		length=1;
	}
	
	public void append(int value)
	{
		Node newNode=new Node(value);
		if(length==0)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
		}
		length++;
	}
	public void prepend(int value)
	{
		Node newNode=new Node(value);
		if(length==0)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			newNode.next=head;
			head=newNode;
		}
		length++;
	}
	public Node removeLast()
	{
		if(length==0)
		{
			return null;
		}
		Node temp=head;
		Node pre=head;
		while(temp.next!=null)
		{
			pre=temp;
			temp=temp.next;
		}
		pre=tail;
		tail.next=null;
		length--;
		if(length==0)
		{
			head=null;
			tail=null;
		}
		return temp;
	}
	public Node removeFirst()
	{
		if(length==0)
		{
			return null;
		}
		Node temp=head;
		head=temp.next;
		temp.next=null;
		length--;
		if(length==0)
		{
			tail=null;
		}
		return temp;
	}
	public Node get(int index)
	{
		if(index<0||index>=length)
		{
			return null;
		}
		Node temp=head;
		for(int i=0;i<index;i++)
		{
			temp=temp.next;
		}
		return temp;
	}
	public boolean set(int index,int value)
	{
		Node temp=get(index);
		if(temp!=null)
		{
			temp.value=value;
			return true;
		}
		return false;
	}
	public boolean insert(int index,int value)
	{
		if(index<0||index>=length)
		{
			return false;
		}
		if(index==0)
		{
			prepend(value);
			return true;
		}
		if(index==length-1)
		{
			append(value);
			return true;
		}
		Node newNode=new Node(value);
		Node temp=get(index-1);
		newNode.next=temp.next;
		temp.next=newNode;
		length++;
		return true;
	}
	public Node remove(int index)
	{
		if(index<0||index>=length)
		{
			return null;
		}
		if(index==0)
		{
			Node res=removeFirst();
			return res;
		}
		if(index==length-1)
		{
			Node res=removeLast();
			return res;
		}
		Node temp=get(index+1);
		Node pre=get(index-1);
		pre.next=temp;
		temp.next=null;
		length--;
		return temp;
	}
	public void reverse()
	{
		Node temp=head;
		head=tail;
		tail=temp;
		Node before=null;
		Node after=temp.next;
		
		for(int i=0;i<length;i++)
		{
			after=temp.next;
			temp.next=before;
			before=temp;
			temp=after;
		}
	}
	public void printList()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.println(temp.value);
			temp=temp.next;
		}
	}
	public void getHead()
	{
		System.out.println("Head="+head.value);
	}
	public void getTail()
	{
		System.out.println("Tail="+tail.value);
	}
	public void getLength()
	{
		System.out.println("Length="+length);
	}
}
public class Main {

	public static void main(String[] args) {
		LinkedList l=new LinkedList(11);
//		l.getHead();
//		l.getTail();
//		l.getLength();
//		System.out.println("Removed Element:"+l.removeLast().value);
//		l.append(3);
//		l.prepend(1);
		l.append(3);
		l.append(23);
		l.append(7);
//		System.out.println("Removed="+l.remove(2).value);
		l.reverse();
//		System.out.println("Element at Index:"+l.get(1).value);
		l.printList();

	}

}
