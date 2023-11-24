package Pertemuan9.Membership.member;

import Pertemuan9.Membership.dao.MemberDao;
import Pertemuan9.Membership.jenis_member.JenisMember;
import java.awt.event.*;
import java.util.UUID;

public class MemberButtonSimpanActionListener  implements ActionListener{
    private MemberFrame memberFrame;
    private MemberDao memberDao;

    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }

    public void actionPerformed(ActionEvent e) {
        String nama = this.memberFrame.getNama();
        if(nama.isEmpty()) {
            this.memberFrame.showAlert("Nama Tidak Boleh Kosong !!!");
        } else {
            JenisMember jenisMember = this.memberFrame.getJenisMember();
            Member member = new Member();
            member.setId(UUID.randomUUID().toString());
            member.setNama(nama);
            member.setJenisMember(jenisMember);

            this.memberFrame.addMember(member);
            this.memberDao.insert(member);
        }
    }
}
