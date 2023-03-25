package Model;

import Model.Association;

public class BinaryTree<K extends Comparable<K>, V> {
    private Association<K, V> data;
    private BinaryTree<K, V> left;
    private BinaryTree<K, V> right;
    private boolean alreadyPrinted;

    public BinaryTree() {
        data = null;
        left = null;
        right = null;
        alreadyPrinted = false;
    }

    public BinaryTree(Association<K, V> data) {
        this.data = data;
        left = null;
        right = null;
        alreadyPrinted = false;
    }

    public void setData(Association<K, V> data) {
        this.data = data;
    }

    public Association<K, V> getValue() {
        return data;
    }

    public void insert(Association<K, V> value) {
        if (value.getKey() == null) {
            return;
        }

        int res = value.getKey().compareTo(data.getKey());

        if (res <= 0) {
            if (left == null) {
                left = new BinaryTree<>(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new BinaryTree<>(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(K key) {
        int res = key.compareTo(data.getKey());

        if (res == 0) {
            return true;
        } else if (res < 0) {
            if (left == null) {
                return false;
            } else {
                return left.contains(key);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(key);
            }
        }
    }

    public V get(K key) {
        int res = key.compareTo(data.getKey());

        if (res == 0) {
            return data.getValue();
        } else {
            if (res < 0) {
                return left == null ? null : left.get(key);
            } else {
                return right == null ? null : right.get(key);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }

        if (!alreadyPrinted) {
            System.out.println(data.toString());
            alreadyPrinted = true;
        }

        if (right != null) {
            right.printInOrder();
        }
    }

    private int stringCompare(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int) str1.charAt(i);
            int str2_ch = (int) str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        } else {
            return 0;
        }
    }

    public BinaryTree<K, V> search(K key) {
        int res = key.compareTo(data.getKey());

        if (res == 0) {
            return this;
        } else if (res < 0) {
            if (left == null) {
                return null;
            } else {
                return left.search(key);
            }
        } else {
            if (right == null) {
                return null;
            } else {
                return right.search(key);
            }
        }
    }
}