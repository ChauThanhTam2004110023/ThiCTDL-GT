package com.tamct2004110023.kiemtracuoiky;

import java.util.Scanner;

public class TestDrive {
    static MyQuanLyKhoHang ql = new MyQuanLyKhoHang();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    static void menu()
    {
        System.out.println("----------MENU----------");
        System.out.println("1.Them hang vao danh sách");
        System.out.println("2.In danh sach");
        System.out.println("3.Tìm kiếm đầu danh sách");
        System.out.println("4.Thêm vào đầu danh sách");
        System.out.println("5.Xóa hàng");
        System.out.println("6.Xóa head");
        System.out.println("7.Xóa tail");
        System.out.println("8.Sửa hàng");
        System.out.println("9.Tăng dần");
        System.out.println("10.Giảm dần");
        int n = sc.nextInt();
        switch(n)
        {
            case 1: themHang(); break;
            case 2: inThongTin(); break;
            case 3: timXongInthongTin(); break;
            case 4: themDangTruoc(); break;
            case 5: xoaDS(); break;
            case 6: xoaHead(); break;
            case 7: xoaTail(); break;
            case 8: suaDS(); break;
            case 9: tangDan(); break;
            case 10: giamDan(); break;
            default: 
            {
                System.out.println("Du lieu khong dung");
                nhanEnterDeTiepTuc();
                menu(); break;
            }
        }
    }
    static void nhanEnterDeTiepTuc()
    {
        System.out.println("Nhan enter de tiep tuc");
        sc.nextLine();
    }
    static void nhapThongTin()
    {
        ql.themHang();
        nhanEnterDeTiepTuc(); 
        menu();
    }
    static void themHang()
    {
        while(true)
        {
            ql.add();
            System.out.println("Them hang (y/n): ");
            if(sc.nextLine().equals("n"))
            {
                break;
            }
        }
        nhanEnterDeTiepTuc();
        menu();
    }
    static void inThongTin()
    {
        ql.inDS();
        nhanEnterDeTiepTuc();
        menu();
    }
    static void timXongInthongTin()
    {
        System.out.println("Nhap ten hang can tim: ");
        String tenHangHoa = sc.nextLine();
        ql.timXongInthongTin(tenHangHoa);
        nhanEnterDeTiepTuc();
        menu();
    }
    static void themDangTruoc()
    {
        System.out.println("Nhap ten hang can them: ");
        String tenHangHoa = sc.nextLine();
        ql.timRoiThemVaoDangTruoc(tenHangHoa);
        nhanEnterDeTiepTuc();
        menu();
    }
    static void xoaDS()
    {
        System.out.println("Nhập tên hàng cần xóa: ");
        String tenHangHoa = sc.nextLine();
        ql.xoaDS(tenHangHoa);
        nhanEnterDeTiepTuc();
        menu();
    }
    
    static void xoaHead()
    {
        ql.xoaHead();
        nhanEnterDeTiepTuc();
        menu();
    }

    static void xoaTail()
    {
        ql.xoaTail();
        nhanEnterDeTiepTuc();
        menu();
    }
    static void suaDS()
    {
        System.out.println("Nhập hàng cần sửa: ");
        String tenHangHoa = sc.nextLine();
        sc.nextLine();
        System.out.println("Giá: ");
        int giaNhap = sc.nextInt();
        System.out.println("Sô lượng tồn kho: ");
        int soLuongTonKho = sc.nextInt();
        System.out.println("Ngày nhập kho: ");
        int ngayNhapKho = sc.nextInt();
        ql.suaDS(tenHangHoa, giaNhap, soLuongTonKho, ngayNhapKho);
        nhanEnterDeTiepTuc();
        menu();
    }

    static void tangDan()
    {
        ql.tangDan();
        nhanEnterDeTiepTuc();
        menu();
    }
    static void giamDan()
    {
        ql.giamDan();
        nhanEnterDeTiepTuc();
        menu();
    }

}
