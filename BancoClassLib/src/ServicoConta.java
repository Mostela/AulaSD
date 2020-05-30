public class ServicoConta {
    public String[] consultarDadosConta(int idConta) {
        System.out.println("Dentro do método consultarDadosConta ");
        String[] dadosConta = null;

        try {
            Conta conta = new Conta();
            conta.setId(idConta);

            if (conta.recuperar()) {
                dadosConta = new String[2];
                dadosConta[0] = conta.getNome();
                dadosConta[1] = Double.toString(conta.getSaldo());
            } else {
                System.out.println("Não foi possível recuperar a conta com o id " + idConta);
            }

        }catch (Exception e) {
            System.out.println("Erro no serviço consultarDadosConta: " + e.getMessage());
        }

        return dadosConta;
    }
}