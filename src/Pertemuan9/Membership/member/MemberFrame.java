package Pertemuan9.Membership.member;

import Pertemuan9.Membership.dao.JenisMemberDao;
import Pertemuan9.Membership.dao.MemberDao;
import Pertemuan9.Membership.jenis_member.JenisMember;

import javax.swing.*;
import java.util.List;

    public class MemberFrame extends JFrame {
        private List<JenisMember> jenisMemberList;
        private List<Member> memberList;
        private JTextField textFieldName;
        private MemberTableModel tableModel;
        private JComboBox comboJenis;
        private MemberDao memberDao;
        private JenisMemberDao jenisMemberDao;

        public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            this.memberDao = memberDao;
            this.jenisMemberDao = jenisMemberDao;

            this.memberList = memberDao.findAll();
            this.jenisMemberList = jenisMemberDao.findAll();

            JLabel labelInput = new JLabel("Nama:  ");
            labelInput.setBounds(15, 40, 350, 10);

            textFieldName = new JTextField();
            textFieldName.setBounds(15, 60, 350, 30);

            JLabel labelJenis = new JLabel("Jenis Member:  ");
            labelJenis.setBounds(15, 100, 350, 10);

            comboJenis = new JComboBox();
            comboJenis.setBounds(15, 120, 350, 30);

            JButton button = new JButton("Simpan");
            button.setBounds(15, 160, 100, 40);

            JTable table = new JTable();
            JScrollPane scrollableTable = new JScrollPane(table);
            scrollableTable.setBounds(15, 220, 350, 200);

            tableModel = new MemberTableModel(memberList);
            table.setModel(tableModel);

            MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao);

            button.addActionListener(actionListener);

            this.add(labelInput);
            this.add(textFieldName);
            this.add(labelJenis);
            this.add(comboJenis);
            this.add(button);
            this.add(scrollableTable);

            this.setSize(400, 500);
            this.setLayout(null);
        }

        public void populateComboJenis() {
            jenisMemberList = this.jenisMemberDao.findAll();
            comboJenis.removeAllItems();
            for (JenisMember jenisMember : jenisMemberList) {
                comboJenis.addItem(jenisMember.getNama());
            }
        }

        public String getNama() {
            return textFieldName.getText();
        }

        public JenisMember getJenisMember() {
            return jenisMemberList.get(comboJenis.getSelectedIndex());
        }

        public void addMember(Member member) {
            tableModel.add(member);
            textFieldName.setText("");
        }

        public void showAlert(String message) {
            JOptionPane.showMessageDialog(this, message);
        }
    }