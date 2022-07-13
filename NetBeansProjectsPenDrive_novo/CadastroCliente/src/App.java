
import dao.ClienteMapDAO;
import dao.IClienteDAO;
import domain.Cliente;
import java.util.Arrays;
import javax.swing.JOptionPane;



/**
 *
 * @author manoel.carvalho
 */
public class App {
    
    private static IClienteDAO iClienteDAO;
    
    public static void main(String[] args){
        iClienteDAO = new ClienteMapDAO();
        
        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração, ou 5 para sair"
                ,"Green dinner", JOptionPane.INFORMATION_MESSAGE);
        
        while (!isOpcaoValida(opcao)){
            if ("".equals(opcao)){
                sair();
            }
            opcao = opcao = JOptionPane.showInputDialog(null,
                "Opção inválida!!! Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração, ou 5 para sair"
                ,"cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
        
        while (isOpcaoValida(opcao)){
            
            if (isOpcaoSair(opcao)) {
                sair();
            }else if (isCadastro(opcao)){
                String dados = JOptionPane.showInputDialog(null,
                "Digite os dados do cliente separados por virgula,conforme exemplo: Nome, Cpf, Telefone, Endereço, numero, Cidade, Estado"
                ,"cadastrar novo cliente", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            }else if(isConsulta(opcao)){
                String dados = JOptionPane.showInputDialog(null,
                "Digite o CPF do cliente"
                ,"Consultar cliente", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            }else if(isExclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                "Digite o CPF do cliente"
                ,"Excluir cliente", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            }else if(isAlteracao(opcao)){
                String cliente = JOptionPane.showInputDialog(null,
                "Digite o cpf do cliente que deseja alterar os dados:"
                ,"Atualizar dados cliente", JOptionPane.INFORMATION_MESSAGE);
                confronto(cliente);
                
                /*
                 String dados = JOptionPane.showInputDialog(null,
                "Digite os dados do cliente separados por virgula,conforme exemplo: Nome, Cpf, Telefone, Endereço, numero, Cidade, Estado"
                ,"cadastrar novo cliente", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
                */
            }
            /*
            else {
                 String dados = JOptionPane.showInputDialog(null,
                "Digite os dados do cliente separados por virgula,conforme exemplo: Nome, Cpf, Telefone, Endereço, numero, Cidade, Estado"
                ,"cadastro", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }
            */
            opcao = opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração, ou 5 para sair"
                ,"cadastro", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }

    private static boolean isOpcaoValida(String opcao) {
        if("1".equals(opcao)|| "2".equals(opcao)|| "3".equals(opcao)
                || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void sair() {
        
        String clientesCadastrados = "";
        for (Cliente cliente : iClienteDAO.buscarTodos()) {
            clientesCadastrados += cliente.toString() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, 
                "Clientes cadastrados: " + clientesCadastrados,
                "Saindo do Sistema",JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
        
    }

    private static boolean isOpcaoSair(String opcao) {
        if("5".equals(opcao)){
            return true;
        }
        return false;
    
    }

    private static boolean isCadastro(String opcao) {
       if("1".equals(opcao)){
           return true;
       }
       return false;
    }

    private static void cadastrar(String dados) {
        String[] dadosCadastrar = dados.split(",");
        // validar se todos os campos estão preechidos.
        // se não passar null no construtor onde o valor é nulo. usado o if
        // validar se somente numeros foram inseridos nas colunas cpf,telefone,numero.
        
        Cliente cliente = new Cliente(dadosCadastrar[0],dadosCadastrar[1],dadosCadastrar[2],dadosCadastrar[3]
                ,dadosCadastrar[4],dadosCadastrar[5],dadosCadastrar[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso",
                    "Cadastro Cliente", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null,"Cliente já cadastrado!",
                    "Cadastro Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isConsulta(String opcao) {
       if("2".equals(opcao)){
           return true;
       }
       return false;
    }

    private static void consultar(String dados) {
        //validar se foi passado somente o cpf
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
         if(cliente != null) {
            JOptionPane.showMessageDialog(null,"Cliente cadastrado: " + cliente.toString(),
                    "Cadastro Cliente", JOptionPane.INFORMATION_MESSAGE);
        } else{
             JOptionPane.showMessageDialog(null,"Cliente não cadastrado!",
                    "Cadastro Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
        
       
    }

    private static boolean isExclusao(String opcao) {
         if("3".equals(opcao)){
           return true;
       }
       return false;
    }

    private static void excluir(String dados) {
        iClienteDAO.excluir(Long.parseLong(dados));
        
         JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso!",
                    "Excluindo Cliente", JOptionPane.INFORMATION_MESSAGE);
    }
    
     private static void confronto(String cliente) {
        
        Cliente clienteConfronto = iClienteDAO.consultar(Long.parseLong(cliente));
       
        if(clienteConfronto == null) {
            JOptionPane.showMessageDialog(null,"Cliente não cadastrado no sistema",
                    "Cadastro Cliente", JOptionPane.INFORMATION_MESSAGE);
        }else{
            String dados = JOptionPane.showInputDialog(null,
                "Digite os dados atualizados do cliente separados por virgula,conforme exemplo: Nome, Cpf, Telefone, Endereço, numero, Cidade, Estado"
                ,"cadastrar novo cliente", JOptionPane.INFORMATION_MESSAGE);
           
            atualizar(dados);
        }
        
     }
    

    private static void atualizar(String dados) {
     
       
       String[] dadosAtualizar = dados.split(",");
       Cliente clienteAtualizar = new Cliente(dadosAtualizar[0],dadosAtualizar[1],dadosAtualizar[2],dadosAtualizar[3]
       ,dadosAtualizar[4],dadosAtualizar[5],dadosAtualizar[6]);
       
       Boolean isAlterar = iClienteDAO.alterar(clienteAtualizar);
       
       if(isAlterar){
            JOptionPane.showMessageDialog(null,"Dados do cliente alterados com sucesso! ",
                    "Alteração de dados Cliente", JOptionPane.INFORMATION_MESSAGE);
           
       }else{
           JOptionPane.showMessageDialog(null,"Erro ao atualizar os dados!",
                    "Alteração de dados Cliente", JOptionPane.INFORMATION_MESSAGE);
       }
       
       
    }

    private static boolean isAlteracao(String opcao) {
       if("4".equals(opcao)){
           return true;
       }
       return false;
    }

   
    
}
