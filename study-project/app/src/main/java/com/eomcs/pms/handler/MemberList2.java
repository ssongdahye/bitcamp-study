package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;

public class MemberList2 {
  static class Node {
    Member member;
    Node next;

    public Node(Member member) {
      this.member = member;
    }
  }

  Node head;
  Node tail;
  int size = 0;

  public void add(Member member) {
    Node node = new Node(member);
    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public Member[] toArray() {
    Member[] arr = new Member[this.size];
    Node node = head;
    for (int i = 0; i < size; i++) {
      arr[i] = node.member;
      node = node.next;
    }

    return arr;
  }

  public boolean remove(Member member) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.member == member) {
        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
        }
        node.next = null; // 다음 노드와의 연결을 끊는다.
        if (node == tail) { // 삭제할 현재 노드가 마지막 노드라면
          tail = prev; // 이전 노드를 마지막 노드로 설정한다.
        }
        size--;
        return true;
      }
      // 현재 노드가 아니라면,
      prev = node; // 현재 노드의 주소를 prev 변수에 저장하고,
      node = node.next; // node 변수에는 다음 노드의 주소를 저장한다.
    }
    return false;
  }

  public Member findByNo(int no) {
    Node node = head;

    while (node != null) {
      if (node.member.no == no) {
        return node.member;
      }
      node = node.next;
    }
    return null;
  }

  public boolean exist(String name) {
    Node node = head;

    while (node != null) {
      if (node.member.name.equals(name)) {
        return true;
      }
      node = node.next;
    }
    return false;
  }
}