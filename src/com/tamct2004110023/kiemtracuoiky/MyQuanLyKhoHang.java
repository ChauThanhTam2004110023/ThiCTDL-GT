package com.tamct2004110023.kiemtracuoiky;

import java.util.Scanner;

public class MyQuanLyKhoHang {
    
    Node head;
    Node tail;
    Node current;
    Node previous;
    Node snap;
    Node temp;
    Node full;
    Scanner sc = new Scanner(System.in);

    public MyQuanLyKhoHang()
    {
       add("Vang", 10, 10, "1-1-2022");
       add("Tim", 20, 20, "12-2-2022");
       add("Trang", 30, 30, "3-12-2022");
       add("Xanh", 40, 40, "11-2-2022");
       add("Den", 50, 50, "1-3-2022");
       add("Nau", 60, 60, "2-4-2022");
       add("Do", 70, 70, "1-5-2022");
       add("Duong", 80, 80, "15-6-2022");
       add("Cham", 90, 90, "1-12-2022");
       add("Luc", 11, 11, "16-2-2022");
       add("Sac", 12, 12, "18-5-2022");
       add("Cam", 13, 13, "1-2-2022");
       add("Huong", 14, 14, "2-4-2022");
       add("La", 15, 15, "30-4-2022");
       add("La cam", 16, 16, "30-12-2022");
       add("Hong", 17, 17, "20-2-2022");
       add("Tham", 18, 18, "30-10-2022");
       add("Sen", 20, 20, "28-2-2022");
       add("Do nhat", 19, 19, "15-7-2022");
       add("Bac", 21, 21, "1-7-2022");
       add("Si", 22, 22, "2-9-2022");
       
    }

    void add(String ten, int gia, int sl, String ngay)
    {
        Node newNode = new Node(ten, gia, sl, ngay);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }


    Node themHang()
    {
        System.out.println("Tên hàng hóa: ");
        String tenHangHoa = sc.nextLine();
        sc.nextLine();
        System.out.println("Giá nhập: ");
        int giaNhap = sc.nextInt();
        System.out.println("Số lượng tồn kho: ");
        int soLuongTonKho = sc.nextInt();
        sc.nextLine();
        System.out.println("Ngày nhập kho: ");
        String ngayNhapKho = sc.nextLine();
        Node node = new Node(tenHangHoa, giaNhap, soLuongTonKho, ngayNhapKho); 
        return node;
    } 

    void add()
    {
        Node newNode = themHang();
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }

    

    void inDS()
    {
        Node current = head;
        if(head == null)
        {
            System.out.println("Không có kết quả cần tim");
            return;
        }
        System.out.println("Kết quả cần tìm là: ");
        while(current != null)
        {
            current.inThongTin();
            current = current.next;
        }
    }

    boolean tim(String tenHangHoa)
    {
        current = head;
        boolean result = false;
        while(current != null)
        {
            if(current.tenHangHoa.equals(tenHangHoa))
            {
                result = true;
                return result;
            }
            current = current.next;
        }
        return result;
    }

    void timXongInthongTin(String tenHangHoa)
    {
        if(true == tim(tenHangHoa))
        {
           current.inThongTin();
        }
        else
        {
            System.out.println("Khong tìm thấy");
        }
    }

    void themDauDS()
    {
        Node newNode = themHang();
        newNode.next = head;
        head = newNode;
    }

    void timDangTruoc()
    {
        previous = head;
        while(previous != null)
        {
            if(previous.next == current)
            {
                return;
            }
            previous = previous.next;
        }
    }
   
    void themDangTruoc()
    {
        timDangTruoc();
        Node newNode = themHang();
        previous.next = newNode;
        previous.next.next = current;
    }

    void timKiemDauDS()
    {
        previous = head;
        while(current != null)
        {
            if(previous.next == current)
            {
                return;
            }
            current.inThongTin();
            previous = previous.next;
        }
    }

    void timRoiThemVaoDangTruoc(String tenHangHoa)
    {
        if(true == tim(tenHangHoa))
        {
            if(current == head)
            {
                themDangTruoc();
            }
        }
        else
        {
            themDangTruoc();
        }
    }

    void xoa(String tenHangHoa)
    {
       if(true == tim(tenHangHoa))
       {
           if(current == head)
           {
               xoaHead();
           }
           else if(current == tail)
           {
               xoaTail();
           }
       }
       else
       {
           System.out.println("Không có trong danh sách");
       }
    } 

    void xoaHead()
    {
        current = head;
        if(head == null)
        {
            System.out.println("Khong co trong danh sach");
            return;
        }
        head = head.next;
        System.out.println("Xoa dau thanh cong");
    }

    void xoaTail()
    {
        current = head;
        while(current != null)
        {
            if(current != null)
            {
                if(current.next == tail)
                {
                    tail = current;
                    current.next = null;
                    return;
                }
                current = current.next;
            }
        }
    }

    void xoaDS(String tenHangHoa)
    {
        if(true == tim(tenHangHoa))
        {
            if(current == head)
            {
                xoaHead();
            }
            else if(current == tail)
            {
                xoaTail();
            }
        }
    }

    void suaDS(String tenHangHoa, int giaNhap, int soLuongTonKho, int ngayNhapKho)
    {
        if(true == tim(tenHangHoa))
        {
            Node newNode = themHang();
            current.tenHangHoa = newNode.tenHangHoa;
            current.giaNhap = newNode.giaNhap;
            current.soLuongTonKho = newNode.soLuongTonKho;
            current.ngayNhapKho = newNode.ngayNhapKho;
            return;
        }
        else
        {
            System.out.println("Không có trong danh sách");
        }
    }

    void thongTin()
    {
        temp = new Node();
        temp.tenHangHoa = snap.tenHangHoa;
        temp.giaNhap = snap.giaNhap;
        temp.soLuongTonKho = snap.soLuongTonKho;
        temp.ngayNhapKho = snap.ngayNhapKho;

        snap.tenHangHoa = current.tenHangHoa;
        snap.giaNhap = current.giaNhap;
        snap.soLuongTonKho = current.soLuongTonKho;
        snap.ngayNhapKho = current.ngayNhapKho;

        current.tenHangHoa = temp.tenHangHoa;
        current.giaNhap = temp.giaNhap;
        /* current.soLuongTonKho = current.soLuongTonKho;
        current.ngayNhapKho = current.ngayNhapKho; */
    }

    void tangDan()
    {
        inDS();
        current = head;
        while(current != null)
        {
            temp = current;
            full = current;
            while(full != null)
            {
                if(temp.giaNhap < full.giaNhap)
                {
                    snap = full;
                }
                full = full.next;
            }
            thongTin();
            current = current.next;
        }
    }

   void giamDan()
   {
       inDS();
       current = head;
       while(current != null)
       {
           temp = current;
           full = current;
           while(full != null)
           {
               if(temp.giaNhap > full.giaNhap)
               {
                   snap = full;
               }
               full = full.next;
           }
           thongTin();
           current = current.next;
       }
   }
}
