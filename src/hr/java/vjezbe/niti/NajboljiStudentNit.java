package hr.java.vjezbe.niti;

public class NajboljiStudentNit implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
	//private static final Logger logger = LoggerFactory.getLogger(NajboljiStudentNit.class);

//	@Override
//	public void run() {
//
//		try {
//
//			List listaStudent = BazaPodataka.dohvatiStudenta();
//
//			Double najboljiProsjek = 0d;
//			Student najboljiStudent = null;
//
//			for (Student student : listaStudent) {
//
//				if (Optional.of(najboljiProsjek).isEmpty()) {
//					najboljiStudent = student;
//				}
//
//				List listaIspita = BazaPodataka.dohvatiIspite();
//
//				List listaIspitaZaStudenta = listaIspita.stream()
//						.filter(p -> p.getStudent().getId().equals(student.getId())).collect(Collectors.toList());
//
//				OptionalDouble prosjek = listaIspitaZaStudenta.stream().mapToDouble(p -> p.getOcjena()).average();
//				if (prosjek.isPresent() && prosjek.getAsDouble() > najboljiProsjek) {
//					najboljiProsjek = prosjek.getAsDouble();
//					najboljiStudent = student;
//				}
//
//			}
//			DecimalFormat df = new DecimalFormat("#,##0.00");
//			if (Optional.of(najboljiStudent).isPresent()) {
//				Main.stage.setTitle("Najbolji student: " + najboljiStudent.getPrezime() + " " + najboljiStudent.getIme()
//				+ " (" + df.format(najboljiProsjek) + ")");
//			}
//
//		} catch (BazaPodatakaException e) {
//			logger.error("Doslo je do pogreske kod dohvacanja studenta");
//			System.err.println(e);
//		}
//	}
//}
