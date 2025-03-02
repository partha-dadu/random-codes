package com.partha.random.heap;

public class HeapUtilities {

    public static void main(String[] args) {
        HeapUtilities heapUtilities = new HeapUtilities();
        int[] nums = {3,6,5,0,8,2,1,9};
        heapUtilities.validateIncreaseKey(nums,4,20);
        heapUtilities.validateDecreaseKey(nums,2,4);
    }
    /**
     * Assuming the Array being passed is already a Heap
     * **/
    public void increaseKeyInHeap(int[] nums, int index, int value){
        if(nums == null || nums.length == 0){
            return;
        }
        int i = index;
        nums[index] = value;
        while (i > 0 || nums[i/2] > nums[i]){
            if(nums[i/2] < nums[i]){
                int temp = nums[i/2];
                nums[i / 2] = nums[i];
                nums[i] = temp;
            }
            i = i / 2;

        }
    }

    public void validateIncreaseKey(int[] nums, int index, int value){
        BuildHeapify buildHeapify = new BuildHeapify();
        buildHeapify.buildHeap(nums,0, nums.length);
        int i =0;
        System.out.println("--------------------");
        while(i < nums.length){
            System.out.println(nums[i]);
            i++;

        }
        increaseKeyInHeap(nums,5,20);
        System.out.println("---------------");
        i=0;
        while(i < nums.length){
            System.out.println(nums[i]);
            i++;

        }
    }

    public void validateDecreaseKey(int[] nums, int index, int value){
        BuildHeapify buildHeapify = new BuildHeapify();
        buildHeapify.buildHeap(nums,0, nums.length);
        int i =0;
        System.out.println("--------------------");
        while(i < nums.length){
            System.out.println(nums[i]);
            i++;

        }
        decreaseKey(nums,2,4);
        System.out.println("---------------");
        i=0;
        while(i < nums.length){
            System.out.println(nums[i]);
            i++;

        }
    }

    public void decreaseKey(int[] nums, int index, int value){
        if(nums == null || nums.length == 0)
            return;
        int i = index;
        nums[i] = value;
        while ( i < nums.length ){
            int l = 2*i+1;
            int r = 2*i+2;
            if(l < nums.length || r < nums.length){
                if(nums[i] > nums[l] && nums[i] > nums[r])
                    break;
               BuildHeapify buildHeapify = new BuildHeapify();
               buildHeapify.heapifyArray(nums,i, nums.length);
            }
            break;

        }
    }
}
