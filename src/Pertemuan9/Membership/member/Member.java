package Pertemuan9.Membership.member;

import Pertemuan9.Membership.jenis_member.JenisMember;

public class Member {
    public String id;
    public String nama;

    private JenisMember jenisMember;
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }

    public void setJenisMember(JenisMember jenisMember) {
        this.jenisMember = jenisMember;
    }

    public JenisMember getJenisMember() {
        return this.jenisMember;
    }
}
