# coding: utf8

to_sort_list = [1, 10, 9, 4, 5, 3]


def quick_sort(sort_list):
    left_list, middle_list, right_list = [], [], []
    if len(sort_list) == 0:
        return []
    pivot = sort_list[0]
    for item in sort_list:
        if item < pivot:
            left_list.append(item)
        elif item == pivot:
            middle_list.append(item)
        else:
            right_list.append(item)
    return quick_sort(left_list) + middle_list + quick_sort(right_list)


def quick_sort_inplace_helper(sort_list, start, end):
    if start == end:
        return start
    pivot = sort_list[start]
    i = start + 1
    j = start + 1
    while j <= end:
        if sort_list[j] < pivot:
            sort_list[j], sort_list[i] = sort_list[i], sort_list[j]
            i += 1
        j += 1

    sort_list[i-1], sort_list[start] = sort_list[start], sort_list[i-1]
    return i - 1


def quick_sort_inplace(sort_list, start, end):
    if start >= end:
        return
    index = quick_sort_inplace_helper(sort_list, start, end)
    quick_sort_inplace(sort_list, start, index - 1)
    quick_sort_inplace(sort_list, index+1, end)


#print(quick_sort(to_sort_list))
#quick_sort_inplace(to_sort_list, 0, len(to_sort_list)-1)
#print(to_sort_list)


def heap_sort_adjust_down(sort_list, start, length):
    i = start * 2 + 1
    while i < length:
        if i + 1 < length and sort_list[i] < sort_list[i+1]:
            i += 1
        if sort_list[start] >= sort_list[i]:
            break
        sort_list[i], sort_list[start] = sort_list[start], sort_list[i]
        start = i
        i = i * 2 + 1


def heap_sort_build_max_heap(sort_list):
    length = len(sort_list)
    i = int(length / 2) - 1 if length % 2 == 0 else int(length / 2)
    while i >= 0:
        heap_sort_adjust_down(sort_list, i, length-1)
        i -= 1


def heap_sort(sort_list):
    heap_sort_build_max_heap(sort_list)
    for i in range(len(sort_list)-1, 0, -1):
        sort_list[0], sort_list[i] = sort_list[i], sort_list[0]
        heap_sort_adjust_down(sort_list, 0, i)

