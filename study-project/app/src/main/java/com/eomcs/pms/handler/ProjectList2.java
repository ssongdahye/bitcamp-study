package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;

public class ProjectList2 {
  static class Node {
    Project project;
    Node next;

    public Node(Project project) {
      this.project = project;
    }
  }

  Node head;
  Node tail;
  int size = 0;

  public void add(Project project) {
    Node node = new Node(project);
    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public Project[] toArray() {
    Project[] arr = new Project[this.size];
    Node node = head;
    for (int i = 0; i < size; i++) {
      arr[i] = node.project;
      node = node.next;
    }
    return arr;
  }

  public boolean remove(Project project) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.project == project) {
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

  public Project findByNo(int no) {
    Node node = head;
    while (node != null) {
      if (node.project.no == no) {
        return node.project;
      }
      node = node.next;
    }
    return null;
  }
}